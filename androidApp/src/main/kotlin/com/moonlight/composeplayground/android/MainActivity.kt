package com.moonlight.composeplayground.android

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.defaultComponentContext
import com.moonlight.composeplayground.android.ui.navigation.RootNavGraph
import com.moonlight.composeplayground.feature.navigation.root.RootNavigation
import com.moonlight.composeplayground.feature.navigation.root.RootNavigationFactory

class MainActivity : ComponentActivity() {

    private lateinit var rootNavigation: RootNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootNavigation = RootNavigationFactory.create(defaultComponentContext())
        rootNavigation.openDeepLinkIfNeeded(intent)

        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    RootNavGraph(rootNavigation = rootNavigation)
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        rootNavigation.openDeepLinkIfNeeded(intent)
    }

    private fun RootNavigation.openDeepLinkIfNeeded(intent: Intent?) {
        if (intent == null) {
            return
        }

        val uri = intent.dataString ?: return
        openDeepLink(uri)
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    MyApplicationTheme {
    }
}
