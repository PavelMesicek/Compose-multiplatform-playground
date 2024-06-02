package com.moonlight.composeplayground.feature.navigation.root

import com.moonlight.composeplayground.feature.navigation.deeplink.DeepLinkNavigator
import com.moonlight.composeplayground.feature.navigation.deeplink.DeepLinkResolver
import com.moonlight.composeplayground.util.arch.ViewModelComponent
import com.moonlight.composeplayground.util.ext.viewModel
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.component.inject

internal class RootNavigationComponent(
    componentContext: ComponentContext,
) : ViewModelComponent<RootNavigationViewModel>(componentContext),
    RootNavigation {

    private val rootNavigator: RootSlotNavigator by inject()
    private val deepLinkResolver: DeepLinkResolver by inject()
    private val deepLinkNavigator: DeepLinkNavigator by inject()

    override val viewModel: RootNavigationViewModel by viewModel()

    override val slot: StateFlow<ChildSlot<RootDestination, RootEntry>> =
        rootNavigator.createSlot(componentContext)

    override fun openDeepLink(uri: String) {
        val deepLinkDestination = deepLinkResolver.resolve(uri) ?: return
        deepLinkNavigator.openDeepLink(deepLinkDestination)
    }
}
