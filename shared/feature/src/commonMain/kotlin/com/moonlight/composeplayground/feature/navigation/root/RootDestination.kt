package com.moonlight.composeplayground.feature.navigation.root

import com.moonlight.composeplayground.feature.navigation.home.HomeNavigation
import com.moonlight.composeplayground.feature.navigation.home.HomeNavigationArgs
import com.moonlight.composeplayground.feature.navigation.home.HomeNavigationComponent
import com.moonlight.composeplayground.feature.ui.login.LoginComponent
import com.moonlight.composeplayground.feature.ui.login.LoginScreen
import com.moonlight.composeplayground.util.arch.Destination
import com.moonlight.composeplayground.util.arch.NavEntry
import com.arkivanov.decompose.ComponentContext
import kotlinx.serialization.Serializable

@Serializable
sealed class RootDestination : Destination<RootEntry> {
    @Serializable
    data object Login : RootDestination() {
        override fun createComponent(componentContext: ComponentContext): RootEntry =
            RootEntry.Login(LoginComponent(componentContext))
    }

    @Serializable
    data class Home(val args: HomeNavigationArgs) : RootDestination() {
        override fun createComponent(componentContext: ComponentContext): RootEntry =
            RootEntry.Home(HomeNavigationComponent(componentContext, args))
    }
}

sealed class RootEntry : NavEntry {
    data class Login(val screen: LoginScreen) : RootEntry()
    data class Home(val navigation: HomeNavigation) : RootEntry()
}
