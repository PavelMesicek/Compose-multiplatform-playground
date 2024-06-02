package com.moonlight.composeplayground.feature.navigation.root

import com.moonlight.composeplayground.util.arch.SharedViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.annotation.Factory

@Factory
internal class RootNavigationViewModel :
    SharedViewModel<RootNavigationViewState, Nothing>() {
    override val viewState: MutableStateFlow<RootNavigationViewState> = MutableStateFlow(RootNavigationViewState())
}
