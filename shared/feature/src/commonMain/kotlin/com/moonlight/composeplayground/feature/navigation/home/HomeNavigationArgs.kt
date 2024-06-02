package com.moonlight.composeplayground.feature.navigation.home

import com.moonlight.composeplayground.feature.navigation.deeplink.DeepLinkDestination
import kotlinx.serialization.Serializable

@Serializable
data class HomeNavigationArgs(
    val deepLinkDestination: DeepLinkDestination? = null,
)
