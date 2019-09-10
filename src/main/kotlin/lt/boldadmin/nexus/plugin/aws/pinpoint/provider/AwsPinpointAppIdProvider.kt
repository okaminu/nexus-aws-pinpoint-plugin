package lt.boldadmin.nexus.plugin.aws.pinpoint.provider

object AwsPinpointAppIdProvider {
    fun provide() = System.getenv("AWS_PINPOINT_APP_ID")!!
}
