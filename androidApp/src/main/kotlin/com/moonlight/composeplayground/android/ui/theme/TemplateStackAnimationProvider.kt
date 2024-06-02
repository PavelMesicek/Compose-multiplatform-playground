package com.moonlight.composeplayground.android.ui.theme

import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimationProvider
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.moonlight.composeplayground.android.tools.Constants

/**
 * Stack animation provides animation for all stacks, not necessary to implement fallback animation in children components.
 */
object TemplateStackAnimationProvider : StackAnimationProvider {
    override fun <C : Any, T : Any> provide(): StackAnimation<C, T> {
        return stackAnimation(Constants.Navigation.STACK_ANIMATION_CROSS_FADE_SPEC)
    }
}
