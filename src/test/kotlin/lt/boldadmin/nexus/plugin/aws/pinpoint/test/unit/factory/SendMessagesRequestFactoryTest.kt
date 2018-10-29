package lt.boldadmin.nexus.plugin.aws.pinpoint.test.unit.factory

import com.amazonaws.services.pinpoint.model.MessageRequest
import com.amazonaws.services.pinpoint.model.SendMessagesRequest
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.MessageRequestFactory
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.SendMessagesRequestFactory
import org.junit.Test
import kotlin.test.assertEquals

class SendMessagesRequestFactoryTest {

    @Test
    fun `Creates send message request`() {
        val fromPhoneNumber = "fromPhoneNumber"
        val toPhoneNumber = "toPhoneNumber"
        val message = "message"

        val messageRequestFactoryStub: MessageRequestFactory = mock()
        val messageRequestDummy: MessageRequest = mock()

        val expectedRequest = SendMessagesRequest()
            .withMessageRequest(messageRequestDummy)
            .withApplicationId(System.getenv("AWS_PINPOINT_APP_ID"))

        doReturn(messageRequestDummy).`when`(messageRequestFactoryStub).create(fromPhoneNumber, toPhoneNumber, message)

        val actualRequest = SendMessagesRequestFactory(messageRequestFactoryStub)
            .create(fromPhoneNumber, toPhoneNumber, message)

        assertEquals(expectedRequest, actualRequest)
    }
}