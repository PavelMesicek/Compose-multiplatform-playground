package com.moonlight.composeplayground.feature.ui.third

import kotlinx.coroutines.flow.StateFlow

interface ThirdScreen {
    val viewState: StateFlow<ThirdViewState>
    val actions: Actions

    interface Actions {
        fun onBack()
    }
}
