package lt.boldadmin.nexus.plugin.aws.pinpoint.factory

import com.amazonaws.services.pinpoint.model.DirectMessageConfiguration
import com.amazonaws.services.pinpoint.model.MessageType
import com.amazonaws.services.pinpoint.model.SMSMessage

class DirectMessageConfigurationFactory {
    internal fun create(senderPhoneNumber: String, message: String) =
        DirectMessageConfiguration().withSMSMessage(
            SMSMessage()
                .withBody(message)
                .withMessageType(MessageType.TRANSACTIONAL)
                .withOriginationNumber(senderPhoneNumber)
        )
}