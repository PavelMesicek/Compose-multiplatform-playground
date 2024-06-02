package com.moonlight.composeplayground.feature.navigation.root

import com.arkivanov.decompose.ComponentContext

object RootNavigationFactory {
    fun create(componentContext: ComponentContext): RootNavigation = RootNavigationComponent(componentContext)
}
