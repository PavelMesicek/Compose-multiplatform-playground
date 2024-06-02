package com.moonlight.composeplayground.feature.ui.third

import com.arkivanov.decompose.ComponentContext
import com.moonlight.composeplayground.util.arch.ViewModelComponent
import com.moonlight.composeplayground.util.ext.viewModel
import kotlinx.coroutines.flow.StateFlow

internal class ThirdComponent(
    componentContext: ComponentContext,
) : ViewModelComponent<ThirdViewModel>(componentContext), ThirdScreen {
    override val viewModel: ThirdViewModel by viewModel()
    override val viewState: StateFlow<ThirdViewState> = viewModel.viewState
    override val actions: ThirdScreen.Actions = viewModel
}
