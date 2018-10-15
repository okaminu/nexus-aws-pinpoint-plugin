package lt.boldadmin.nexus.plugin.aws.pinpoint.factory

import com.amazonaws.regions.Regions
import com.amazonaws.services.pinpoint.AmazonPinpointClientBuilder

class AmazonPinpointClientFactory {
    internal fun create(regions: Regions) = AmazonPinpointClientBuilder.standard().withRegion(regions).build()
}