package lt.boldadmin.nexus.plugin.aws.pinpoint.test.unit.factory

import com.amazonaws.services.pinpoint.model.MessageRequest
import com.amazonaws.services.pinpoint.model.SendMessagesRequest
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.MessageRequestFactory
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.SendMessagesRequestFactory
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals

@RunWith(MockitoJUnitRunner::class)
class SendMessagesRequestFactoryTest {

    @Test
    fun `creates send message request`() {
        val fromPhoneNumber = "fromPhoneNumber"
        val toPhoneNumber = "toPhoneNumber"
        val message = "message"

        val messageRequestFactoryStub: MessageRequestFactory = mock()
        val messageRequestDummy: MessageRequest = mock()

        doReturn(messageRequestDummy)
            .`when`(messageRequestFactoryStub)
            .create(fromPhoneNumber, toPhoneNumber, message)

        val actualRequest = SendMessagesRequestFactory(messageRequestFactoryStub)
            .create(fromPhoneNumber, toPhoneNumber, message)

        val expectedRequest = SendMessagesRequest()
            .withMessageRequest(messageRequestDummy)
            .withApplicationId("fa31dc0f27c74def905f19179398b22e")

        assertEquals(expectedRequest, actualRequest)
    }
}