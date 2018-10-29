package lt.boldadmin.nexus.plugin.aws.pinpoint.provider

class AwsPinpointAppIdProvider {
    fun provide() = System.getenv("AWS_PINPOINT_APP_ID")!!
}