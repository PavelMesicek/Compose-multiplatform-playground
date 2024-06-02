package com.moonlight.composeplayground.feature.ui.second

import com.arkivanov.decompose.ComponentContext
import com.moonlight.composeplayground.util.arch.ViewModelComponent
import com.moonlight.composeplayground.util.ext.viewModel
import kotlinx.coroutines.flow.StateFlow

internal class SecondComponent(
    componentContext: ComponentContext,
) : ViewModelComponent<SecondViewModel>(componentContext), SecondScreen {

    override val viewModel: SecondViewModel by viewModel()
    override val viewState: StateFlow<SecondViewState> = viewModel.viewState
    override val actions: SecondScreen.Actions = viewModel
}
