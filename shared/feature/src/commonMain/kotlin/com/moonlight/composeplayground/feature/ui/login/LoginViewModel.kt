package com.moonlight.composeplayground.feature.ui.login

import com.moonlight.composeplayground.feature.navigation.root.RootSlotNavigator
import com.moonlight.composeplayground.network.graphql.api.RickAndMortyApi
import com.moonlight.composeplayground.network.rest.api.StarWarsApi
import com.moonlight.composeplayground.util.arch.SharedViewModel
import co.touchlab.kermit.Logger
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.annotation.Factory

@Factory
internal class LoginViewModel(
    private val starWarsApi: StarWarsApi,
    private val rickAndMortyApi: RickAndMortyApi,
    private val navigator: RootSlotNavigator,
) : SharedViewModel<LoginViewState, Nothing>(),
    LoginScreen.Actions,
    LoginScreen.SuspendActions {

    override val viewState: MutableStateFlow<LoginViewState> = MutableStateFlow(LoginViewState())
    private val logger = Logger.withTag("LoginViewModel")

    init {
        testRestApiClient()
        testGraphqlApiClient()
    }

    private fun testRestApiClient() = launchWithHandler {
        val networkResult = starWarsApi.getPerson(3)
        logger.d { networkResult.toString() }
    }

    private fun testGraphqlApiClient() = launchWithHandler {
        val networkResult = rickAndMortyApi.getEpisodes()
        logger.d { networkResult.toString() }
    }

    override fun onLoginClick() = navigator.showHome()

    override suspend fun refresh() {
        // Lets SwiftUI display refresh indicator for as long as data is being refreshed
        coroutineScope {
            val starWarsCall = async { starWarsApi.getPerson(3) }
            val rickAndMortyCall = async { rickAndMortyApi.getEpisodes() }
            starWarsCall.await().let { logger.d { it.toString() } }
            rickAndMortyCall.await().let { logger.d { it.toString() } }
        }
    }
}
