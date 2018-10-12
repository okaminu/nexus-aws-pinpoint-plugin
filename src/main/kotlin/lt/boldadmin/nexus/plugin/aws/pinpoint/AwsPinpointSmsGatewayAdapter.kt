package lt.boldadmin.nexus.plugin.aws.pinpoint

import com.amazonaws.regions.Regions
import com.amazonaws.services.pinpoint.AmazonPinpointClientBuilder
import com.amazonaws.services.pinpoint.model.*
import lt.boldadmin.nexus.api.SmsGateway

class AwsPinpointSmsGatewayAdapter: SmsGateway {
    override fun send(fromPhoneNumber: String, toPhoneNumber: String, message: String) {
        AmazonPinpointClientBuilder.standard().withRegion(Regions.US_EAST_1).build().sendMessages(
            SendMessagesRequest().withMessageRequest(
                createMessageRequest(toPhoneNumber, message, fromPhoneNumber)
            ).withApplicationId("fa31dc0f27c74def905f19179398b22e")
        )
    }

    private fun createMessageRequest(
        toPhoneNumber: String,
        message: String,
        fromPhoneNumber: String
    ): MessageRequest? {
        return MessageRequest().withAddresses(
            mapOf(
                Pair(
                    toPhoneNumber,
                    AddressConfiguration().withChannelType(ChannelType.SMS)
                )
            )
        ).withMessageConfiguration(
            DirectMessageConfiguration().withSMSMessage(
                SMSMessage().withBody(message)
                    .withMessageType(MessageType.TRANSACTIONAL).withOriginationNumber(
                        fromPhoneNumber
                    )
            )
        )
    }
}