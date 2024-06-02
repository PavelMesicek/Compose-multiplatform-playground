package com.moonlight.composeplayground.feature.ui.first

import com.moonlight.composeplayground.util.arch.ViewModelComponent
import com.moonlight.composeplayground.util.ext.viewModel
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.parameter.parametersOf

internal class FirstComponent(
    componentContext: ComponentContext,
    arg: String,
) : ViewModelComponent<FirstViewModel>(componentContext), FirstScreen {
    override val viewModel: FirstViewModel by viewModel(parameters = { parametersOf(arg) })
    override val viewState: StateFlow<FirstViewState> = viewModel.viewState
    override val actions: FirstScreen.Actions = viewModel
    override val events: Flow<FirstUiEvent> = viewModel.uiEvents
}
