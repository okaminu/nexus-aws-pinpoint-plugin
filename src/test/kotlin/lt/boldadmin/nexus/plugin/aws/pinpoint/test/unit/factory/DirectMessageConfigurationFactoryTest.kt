package lt.boldadmin.nexus.plugin.aws.pinpoint.test.unit.factory

import com.amazonaws.services.pinpoint.model.DirectMessageConfiguration
import com.amazonaws.services.pinpoint.model.MessageType
import com.amazonaws.services.pinpoint.model.SMSMessage
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.DirectMessageConfigurationFactory
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals

@RunWith(MockitoJUnitRunner::class)
class DirectMessageConfigurationFactoryTest {

    @Test
    fun `creates direct message configuration`() {
        val fromPhoneNumber = "fromPhoneNumber"
        val message = "message"

        val actualConfiguration = DirectMessageConfigurationFactory()
            .create(fromPhoneNumber, message)

        val expectedConfiguration = DirectMessageConfiguration().withSMSMessage(
            SMSMessage()
                .withBody(message)
                .withMessageType(MessageType.TRANSACTIONAL)
                .withOriginationNumber(fromPhoneNumber)
        )

        assertEquals(expectedConfiguration, actualConfiguration)
    }
}