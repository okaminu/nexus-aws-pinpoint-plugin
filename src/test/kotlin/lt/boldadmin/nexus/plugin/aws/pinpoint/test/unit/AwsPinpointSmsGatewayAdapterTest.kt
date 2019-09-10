package lt.boldadmin.nexus.plugin.aws.pinpoint.test.unit

import com.amazonaws.regions.Regions
import com.amazonaws.services.pinpoint.AmazonPinpoint
import com.amazonaws.services.pinpoint.model.SendMessagesRequest
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import lt.boldadmin.nexus.plugin.aws.pinpoint.AwsPinpointSmsGatewayAdapter
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.AmazonPinpointClientFactory
import lt.boldadmin.nexus.plugin.aws.pinpoint.factory.SendMessagesRequestFactory
import org.junit.jupiter.api.Test

class AwsPinpointSmsGatewayAdapterTest {

    @Test
    fun `Sends message to phone number`() {
        val fromPhoneNumber = "fromPhoneNumber"
        val toPhoneNumber = "toPhoneNumber"
        val message = "message"

        val clientFactoryStub: AmazonPinpointClientFactory = mock()
        val messagesRequestFactoryStub: SendMessagesRequestFactory = mock()
        val messagesRequestDummy: SendMessagesRequest = mock()
        val amazonPinpointSpy: AmazonPinpoint = mock()

        doReturn(amazonPinpointSpy).`when`(clientFactoryStub).create(Regions.US_EAST_1)
        doReturn(messagesRequestDummy)
            .`when`(messagesRequestFactoryStub).create(fromPhoneNumber, toPhoneNumber, message)

        AwsPinpointSmsGatewayAdapter(clientFactoryStub, messagesRequestFactoryStub)
            .send(fromPhoneNumber, toPhoneNumber, message)

        verify(amazonPinpointSpy).sendMessages(messagesRequestDummy)
    }
}
