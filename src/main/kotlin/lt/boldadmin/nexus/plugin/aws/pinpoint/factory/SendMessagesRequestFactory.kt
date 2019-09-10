package lt.boldadmin.nexus.plugin.aws.pinpoint.factory

import com.amazonaws.services.pinpoint.model.SendMessagesRequest
import lt.boldadmin.nexus.plugin.aws.pinpoint.provider.AwsPinpointAppIdProvider

class SendMessagesRequestFactory(
    private val messageRequestFactory: MessageRequestFactory,
    private val pinpointAppIdProvider: AwsPinpointAppIdProvider
) {
    internal fun create(senderPhoneNumber: String, receiverPhoneNumber: String, message: String) =
        SendMessagesRequest()
            .withMessageRequest(messageRequestFactory.create(senderPhoneNumber, receiverPhoneNumber, message))
            .withApplicationId(pinpointAppIdProvider.provide())
}
