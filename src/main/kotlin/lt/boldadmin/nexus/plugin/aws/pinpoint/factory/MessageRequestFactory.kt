package lt.boldadmin.nexus.plugin.aws.pinpoint.factory

import com.amazonaws.services.pinpoint.model.AddressConfiguration
import com.amazonaws.services.pinpoint.model.ChannelType
import com.amazonaws.services.pinpoint.model.MessageRequest

class MessageRequestFactory(
    private val directMessageConfigurationFactory: DirectMessageConfigurationFactory
) {

    internal fun create(fromPhoneNumber: String, toPhoneNumber: String, message: String) =
        MessageRequest().withAddresses(
            mapOf(
                Pair(
                    toPhoneNumber,
                    AddressConfiguration().withChannelType(ChannelType.SMS)
                )
            )
        ).withMessageConfiguration(
            directMessageConfigurationFactory.create(fromPhoneNumber, message)
        )
}