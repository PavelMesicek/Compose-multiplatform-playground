package com.moonlight.composeplayground.feature.ui.login

import com.moonlight.composeplayground.util.arch.ViewModelComponent
import com.moonlight.composeplayground.util.ext.viewModel
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

internal class LoginComponent(
    componentContext: ComponentContext,
) : ViewModelComponent<LoginViewModel>(componentContext), LoginScreen {
    override val viewModel: LoginViewModel by viewModel()
    override val viewState: StateFlow<LoginViewState> = viewModel.viewState
    override val actions: LoginScreen.Actions = viewModel
    override val suspendActions: LoginScreen.SuspendActions = viewModel
}
