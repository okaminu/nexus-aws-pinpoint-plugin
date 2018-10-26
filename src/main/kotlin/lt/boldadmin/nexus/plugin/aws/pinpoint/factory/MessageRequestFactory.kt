package lt.boldadmin.nexus.plugin.aws.pinpoint.factory

import com.amazonaws.services.pinpoint.model.AddressConfiguration
import com.amazonaws.services.pinpoint.model.ChannelType
import com.amazonaws.services.pinpoint.model.MessageRequest

class MessageRequestFactory(
    private val directMessageConfigurationFactory: DirectMessageConfigurationFactory
) {
    internal fun create(senderPhoneNumber: String, receiverPhoneNumber: String, message: String) =
        MessageRequest()
            .withAddresses(mapOf(receiverPhoneNumber to AddressConfiguration().withChannelType(ChannelType.SMS)))
            .withMessageConfiguration(directMessageConfigurationFactory.create(senderPhoneNumber, message))
}