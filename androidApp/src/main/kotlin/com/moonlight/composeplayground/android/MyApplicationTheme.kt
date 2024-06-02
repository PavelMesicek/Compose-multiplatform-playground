package com.moonlight.composeplayground.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.stack.animation.LocalStackAnimationProvider
import com.moonlight.composeplayground.android.ui.theme.TemplateStackAnimationProvider

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = Color(0xFFBB86FC),
            inversePrimary = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5),
        )
    } else {
        lightColorScheme(
            primary = Color(0xFF6200EE),
            inversePrimary = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5),
        )
    }
    val typography = Typography(
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        ),
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp),
    )

    CompositionLocalProvider(
        LocalStackAnimationProvider provides TemplateStackAnimationProvider,
    ) {
        MaterialTheme(
            colorScheme = colors,
            typography = typography,
            shapes = shapes,
            content = content,
        )
    }
}
