package com.moonlight.composeplayground.feature.ui.first

import com.moonlight.composeplayground.util.arch.UiEvent

sealed class FirstUiEvent : UiEvent<FirstViewState> {
    data class ShowToast(val text: String) : FirstUiEvent()
}
