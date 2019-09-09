package lt.boldadmin.nexus.plugin.aws.pinpoint.test.unit.factory

import com.amazonaws.services.pinpoint.model.DirectMessageConfiguration
import com.amazonaws.services.pinpoint.model.MessageType
import com.amazonaws.services.pinpoint.model.SMSMessage
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.DirectMessageConfigurationFactory
import org.junit.Test
import kotlin.test.assertEquals

class DirectMessageConfigurationFactoryTest {

    @Test
    fun `Creates direct message configuration`() {
        val fromPhoneNumber = "fromPhoneNumber"
        val message = "message"
        val expectedConfiguration = DirectMessageConfiguration().withSMSMessage(
            SMSMessage()
                .withBody(message)
                .withMessageType(MessageType.TRANSACTIONAL)
                .withOriginationNumber(fromPhoneNumber)
        )

        val actualConfiguration = DirectMessageConfigurationFactory.create(fromPhoneNumber, message)

        assertEquals(expectedConfiguration, actualConfiguration)
    }
}
