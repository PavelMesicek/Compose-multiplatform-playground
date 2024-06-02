package com.moonlight.composeplayground.feature.navigation.root

import com.moonlight.composeplayground.feature.navigation.deeplink.DeepLinkDestination
import com.moonlight.composeplayground.feature.navigation.deeplink.DeepLinkNavigator
import com.moonlight.composeplayground.feature.navigation.home.HomeNavigationArgs
import com.moonlight.composeplayground.util.ext.asStateFlow
import com.moonlight.composeplayground.util.ext.componentCoroutineScope
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.annotation.Single

internal interface RootSlotNavigator {
    fun createSlot(componentContext: ComponentContext): StateFlow<ChildSlot<RootDestination, RootEntry>>
    fun showLogin()
    fun showHome()
}

@Single
internal class RootSlotNavigatorImpl : RootSlotNavigator, DeepLinkNavigator {

    private val slotNavigator: SlotNavigation<RootDestination> = SlotNavigation()

    override fun createSlot(componentContext: ComponentContext) = componentContext.childSlot(
        source = slotNavigator,
        serializer = RootDestination.serializer(),
        initialConfiguration = { RootDestination.Login },
        handleBackButton = false,
        childFactory = { destination, childContext ->
            destination.createComponent(childContext)
        },
    ).asStateFlow(componentContext.componentCoroutineScope())

    override fun showLogin() = slotNavigator.activate(RootDestination.Login)

    override fun showHome() = slotNavigator.activate(RootDestination.Home(HomeNavigationArgs()))

    override fun openDeepLink(destination: DeepLinkDestination) {
        slotNavigator.activate(RootDestination.Home(args = HomeNavigationArgs(deepLinkDestination = destination)))
    }
}
