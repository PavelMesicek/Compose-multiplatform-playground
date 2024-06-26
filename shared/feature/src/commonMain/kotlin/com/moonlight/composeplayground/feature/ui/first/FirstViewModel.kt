package com.moonlight.composeplayground.feature.ui.first

import co.touchlab.kermit.Logger
import com.moonlight.composeplayground.feature.navigation.home.HomeStackNavigator
import com.moonlight.composeplayground.resources.MR
import com.moonlight.composeplayground.util.arch.SharedViewModel
import com.moonlight.composeplayground.util.ext.update
import dev.icerock.moko.resources.desc.ResourceFormatted
import dev.icerock.moko.resources.desc.StringDesc
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.isActive
import org.koin.core.annotation.Factory
import kotlin.time.Duration.Companion.milliseconds

@Factory
internal class FirstViewModel(
    private val homeNavigator: HomeStackNavigator,
    private val arg: String,
) : SharedViewModel<FirstViewState, FirstUiEvent>(),
    FirstScreen.Actions {

    override val viewState: MutableStateFlow<FirstViewState> = MutableStateFlow(FirstViewState())

    init {
        launchWithHandler {
            var counter = 0
            while (isActive) {
                update(viewState) {
                    copy(
                        text = StringDesc.ResourceFormatted(stringRes = MR.strings.first_screen_text, 1, counter++),
                    )
                }

                if (counter == 10) {
                    Logger.withTag("FirstViewmodel").d { "Counter reached 10" }
                    sendUiEvent(FirstUiEvent.ShowToast("Counter reached 10 🎉"))
                }

                delay(200.milliseconds)
            }
        }
    }

    override fun onBack() = homeNavigator.pop()

    override fun onNext() = homeNavigator.navigateToSecond()
}
