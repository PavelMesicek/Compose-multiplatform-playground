package com.moonlight.composeplayground.android.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.moonlight.composeplayground.android.ui.screen.LoginScreenUi
import com.moonlight.composeplayground.feature.navigation.root.RootDestination
import com.moonlight.composeplayground.feature.navigation.root.RootEntry
import com.moonlight.composeplayground.feature.navigation.root.RootNavigation
import com.arkivanov.decompose.router.slot.ChildSlot

@Composable
fun RootNavGraph(
    rootNavigation: RootNavigation,
    modifier: Modifier = Modifier,
) {
    val slot: ChildSlot<RootDestination, RootEntry> by rootNavigation.slot.collectAsState()

    Surface(modifier, color = MaterialTheme.colorScheme.background) {
        when (val childInstance = slot.child?.instance) {
            is RootEntry.Home -> HomeNavGraph(
                homeNavigation = childInstance.navigation,
                modifier = Modifier.fillMaxSize(),
            )

            is RootEntry.Login -> LoginScreenUi(
                screen = childInstance.screen,
                modifier = Modifier.fillMaxSize(),
            )

            else -> Unit
        }
    }
}
