package lt.boldadmin.nexus.plugin.aws.pinpoint.test.unit

import com.amazonaws.regions.Regions
import com.amazonaws.services.pinpoint.AmazonPinpoint
import com.amazonaws.services.pinpoint.model.SendMessagesRequest
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import lt.boldadmin.nexus.plugin.aws.pinpoint.AwsPinpointSmsGatewayAdapter
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.AmazonPinpointClientFactory
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.SendMessagesRequestFactory
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AwsPinpointSmsGatewayAdapterTest {

    @Test
    fun `sends message to phone number`() {
        val fromPhoneNumber = "fromPhoneNumber"
        val toPhoneNumber = "toPhoneNumber"
        val message = "message"

        val clientFactoryStub: AmazonPinpointClientFactory = mock()
        val messagesRequestFactoryStub: SendMessagesRequestFactory = mock()
        val messagesRequestStub: SendMessagesRequest = mock()
        val amazonPinpointSpy: AmazonPinpoint= mock()

        doReturn(amazonPinpointSpy).`when`(clientFactoryStub).create(Regions.US_EAST_1)
        doReturn(messagesRequestStub).`when`(messagesRequestFactoryStub)
            .create(fromPhoneNumber, toPhoneNumber, message)

        AwsPinpointSmsGatewayAdapter(clientFactoryStub, messagesRequestFactoryStub)
            .send(fromPhoneNumber, toPhoneNumber, message)

        verify(amazonPinpointSpy).sendMessages(messagesRequestStub)
    }
}