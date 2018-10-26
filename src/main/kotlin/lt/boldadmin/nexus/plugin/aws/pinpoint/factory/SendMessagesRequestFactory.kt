package lt.boldadmin.nexus.plugin.aws.pinpoint.factory

import com.amazonaws.services.pinpoint.model.SendMessagesRequest

class SendMessagesRequestFactory(
    private val messageRequestFactory: MessageRequestFactory
) {
    internal fun create(senderPhoneNumber: String, receiverPhoneNumber: String, message: String) =
        SendMessagesRequest()
            .withMessageRequest(messageRequestFactory.create(senderPhoneNumber, receiverPhoneNumber, message))
            .withApplicationId("fa31dc0f27c74def905f19179398b22e")
}