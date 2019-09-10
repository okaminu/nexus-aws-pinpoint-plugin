package lt.boldadmin.nexus.plugin.aws.pinpoint.test.unit.factory

import com.amazonaws.services.pinpoint.model.*
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.DirectMessageConfigurationFactory
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.MessageRequestFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MessagesRequestFactoryTest {

    @Test
    fun `Creates message request`() {
        val fromPhoneNumber = "fromPhoneNumber"
        val toPhoneNumber = "toPhoneNumber"
        val message = "message"

        val messageConfigurationFactoryStub: DirectMessageConfigurationFactory = mock()
        val messageConfigurationDummy: DirectMessageConfiguration = mock()

        val expectedConfiguration = MessageRequest()
            .withAddresses(mapOf(toPhoneNumber to AddressConfiguration().withChannelType(ChannelType.SMS)))
            .withMessageConfiguration(messageConfigurationDummy)

        doReturn(messageConfigurationDummy).`when`(messageConfigurationFactoryStub).create(fromPhoneNumber, message)


        val actualConfiguration = MessageRequestFactory(messageConfigurationFactoryStub)
            .create(fromPhoneNumber, toPhoneNumber, message)


        assertEquals(expectedConfiguration, actualConfiguration)
    }
}
