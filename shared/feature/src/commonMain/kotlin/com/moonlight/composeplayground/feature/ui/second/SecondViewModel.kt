package com.moonlight.composeplayground.feature.ui.second

import com.moonlight.composeplayground.feature.navigation.home.HomeStackNavigator
import com.moonlight.composeplayground.util.arch.SharedViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.annotation.Factory

@Factory
internal class SecondViewModel(
    private val navigator: HomeStackNavigator,
) : SharedViewModel<SecondViewState, Nothing>(),
    SecondScreen.Actions {
    override val viewState: MutableStateFlow<SecondViewState> = MutableStateFlow(SecondViewState())

    override fun onBack() = navigator.pop()

    override fun onNext() = navigator.navigateToThird()
}
