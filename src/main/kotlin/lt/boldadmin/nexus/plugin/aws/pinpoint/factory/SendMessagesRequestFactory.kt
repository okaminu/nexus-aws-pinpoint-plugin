package lt.boldadmin.nexus.plugin.aws.pinpoint.factory

import com.amazonaws.services.pinpoint.model.SendMessagesRequest

class SendMessagesRequestFactory(
    private val messageRequestFactory: MessageRequestFactory
) {
    internal fun create(senderPhoneNumber: String, receiverPhoneNumber: String, message: String) =
        SendMessagesRequest()
            .withMessageRequest(messageRequestFactory.create(senderPhoneNumber, receiverPhoneNumber, message))
            .withApplicationId(System.getenv("AWS_PINPOINT_APP_ID"))
}