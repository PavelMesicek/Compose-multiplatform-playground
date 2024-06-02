package com.moonlight.composeplayground.platform.injection

import com.moonlight.composeplayground.platform.binding.PlatformBindings
import org.koin.dsl.module

fun platformModule(
    platformBindings: PlatformBindings,
) = module {
    includes(kotlinPlatformModule())
}
