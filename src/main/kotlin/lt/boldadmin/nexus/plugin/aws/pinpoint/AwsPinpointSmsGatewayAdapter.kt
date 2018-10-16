package lt.boldadmin.nexus.plugin.aws.pinpoint

import com.amazonaws.regions.Regions
import lt.boldadmin.nexus.api.SmsGateway
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.AmazonPinpointClientFactory
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.SendMessagesRequestFactory

class AwsPinpointSmsGatewayAdapter(
    private val clientFactory: AmazonPinpointClientFactory,
    private val messagesRequestFactory: SendMessagesRequestFactory
): SmsGateway {

    override fun send(fromPhoneNumber: String, toPhoneNumber: String, message: String) {
        clientFactory
            .create(Regions.US_EAST_1)
            .sendMessages(messagesRequestFactory.create(fromPhoneNumber, toPhoneNumber, message))
    }
}