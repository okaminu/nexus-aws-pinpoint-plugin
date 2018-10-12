package lt.boldadmin.nexus.plugin.aws.pinpoint

import com.amazonaws.regions.Regions
import com.amazonaws.services.pinpoint.AmazonPinpointClientBuilder
import com.amazonaws.services.pinpoint.model.*
import lt.boldadmin.nexus.api.SmsGateway

class AwsPinpointSmsGatewayAdapter: SmsGateway {
    override fun send(phoneNumber: String, message: String) {
        AmazonPinpointClientBuilder.standard().withRegion(Regions.US_EAST_1).build().sendMessages(
            SendMessagesRequest().withMessageRequest(
                MessageRequest().withAddresses(
                    mapOf(
                        Pair(
                            phoneNumber,
                            AddressConfiguration().withChannelType(ChannelType.SMS)
                        )
                    )
                ).withMessageConfiguration(
                    DirectMessageConfiguration().withSMSMessage(
                        SMSMessage().withBody(message)
                            .withMessageType(MessageType.TRANSACTIONAL).withOriginationNumber(
                                ""
                            )
                    )
                )
            ).withApplicationId("fa31dc0f27c74def905f19179398b22e")
        )
    }
}