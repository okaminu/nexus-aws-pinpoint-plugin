package lt.boldadmin.nexus.plugin.aws.pinpoint

import com.amazonaws.regions.Regions
import lt.boldadmin.nexus.api.SmsGateway
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.AmazonPinpointClientFactory
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.SendMessageRequestFactory

class AwsPinpointSmsGatewayAdapter(
    private val clientFactory: AmazonPinpointClientFactory,
    private val messageRequestFactory: SendMessageRequestFactory
): SmsGateway {

    override fun send(fromPhoneNumber: String, toPhoneNumber: String, message: String) {
        clientFactory
            .create(Regions.US_EAST_1)
            .sendMessages(messageRequestFactory.create(fromPhoneNumber, toPhoneNumber, message))
    }
}