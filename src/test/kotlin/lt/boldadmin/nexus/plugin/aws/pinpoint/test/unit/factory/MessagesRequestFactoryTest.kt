package lt.boldadmin.nexus.plugin.aws.pinpoint.test.unit.factory

import com.amazonaws.services.pinpoint.model.*
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.DirectMessageConfigurationFactory
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.MessageRequestFactory
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals

@RunWith(MockitoJUnitRunner::class)
class MessagesRequestFactoryTest {

    @Test
    fun `creates message request`() {
        val fromPhoneNumber = "fromPhoneNumber"
        val toPhoneNumber = "toPhoneNumber"
        val message = "message"

        val messageConfigurationFactory: DirectMessageConfigurationFactory = mock()
        val messageConfiguration: DirectMessageConfiguration = mock()

        doReturn(messageConfiguration)
            .`when`(messageConfigurationFactory)
            .create(fromPhoneNumber, message)

        val actualConfiguration = MessageRequestFactory(messageConfigurationFactory)
            .create(fromPhoneNumber, toPhoneNumber, message)

        val expectedConfiguration = MessageRequest()
            .withAddresses(mapOf(toPhoneNumber to AddressConfiguration().withChannelType(ChannelType.SMS)))
            .withMessageConfiguration(messageConfiguration)

        assertEquals(expectedConfiguration, actualConfiguration)
    }
}