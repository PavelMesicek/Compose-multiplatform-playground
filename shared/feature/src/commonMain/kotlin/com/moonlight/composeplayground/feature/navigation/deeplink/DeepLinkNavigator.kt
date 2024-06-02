package com.moonlight.composeplayground.feature.navigation.deeplink

/**
 * Interface responsible for triggering navigation to provided [DeepLinkDestination].
 */
internal interface DeepLinkNavigator {
    fun openDeepLink(destination: DeepLinkDestination)
}
