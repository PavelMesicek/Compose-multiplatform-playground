@file:OptIn(ExperimentalDecomposeApi::class)

package com.moonlight.composeplayground.android.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.moonlight.composeplayground.android.ui.screen.FirstScreenUi
import com.moonlight.composeplayground.android.ui.screen.SecondScreenUi
import com.moonlight.composeplayground.android.ui.screen.SecretScreenUi
import com.moonlight.composeplayground.android.ui.screen.ThirdScreenUi
import com.moonlight.composeplayground.feature.navigation.home.HomeDestination
import com.moonlight.composeplayground.feature.navigation.home.HomeEntry
import com.moonlight.composeplayground.feature.navigation.home.HomeNavigation
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.androidPredictiveBackAnimatable
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.predictiveBackAnimation
import com.arkivanov.decompose.router.stack.ChildStack

@Composable
fun HomeNavGraph(
    homeNavigation: HomeNavigation,
    modifier: Modifier = Modifier,
) {
    val stack: ChildStack<HomeDestination, HomeEntry> by homeNavigation.stack.collectAsState()
    val actions = homeNavigation.actions

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background,
    ) {
        Children(
            stack = stack,
            modifier = Modifier.fillMaxSize(),
            /**
             * Predictive back animation support predictive gesture back navigation.
             * Is it necessary implement BackHandlerOwner in Components where you want to use predictive gesture animation.
             */
            animation = predictiveBackAnimation(
                backHandler = homeNavigation.backHandler,
                onBack = actions::onBack,
                selector = { backEvent, _, _ -> androidPredictiveBackAnimatable(backEvent) },
            ),
        ) { child ->
            when (val childInstance = child.instance) {
                is HomeEntry.First -> FirstScreenUi(screen = childInstance.screen, modifier = Modifier.fillMaxSize())
                is HomeEntry.Second -> SecondScreenUi(screen = childInstance.screen, modifier = Modifier.fillMaxSize())
                is HomeEntry.Third -> ThirdScreenUi(screen = childInstance.screen, modifier = Modifier.fillMaxSize())
                is HomeEntry.Secret -> SecretScreenUi(screen = childInstance.screen, modifier = Modifier.fillMaxSize())
            }
        }
    }
}
