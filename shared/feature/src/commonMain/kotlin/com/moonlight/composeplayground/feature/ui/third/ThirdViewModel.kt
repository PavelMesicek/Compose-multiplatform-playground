package com.moonlight.composeplayground.feature.ui.third

import com.moonlight.composeplayground.feature.navigation.home.HomeStackNavigator
import com.moonlight.composeplayground.util.arch.SharedViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.annotation.Factory

@Factory
internal class ThirdViewModel(
    private val navigator: HomeStackNavigator,
) : SharedViewModel<ThirdViewState, Nothing>(), ThirdScreen.Actions {

    override val viewState: MutableStateFlow<ThirdViewState> = MutableStateFlow(ThirdViewState())

    override fun onBack() = navigator.pop()
}
