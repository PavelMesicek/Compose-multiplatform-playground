package com.moonlight.composeplayground.platform.injection

import com.moonlight.composeplayground.platform.IosPlatform
import com.moonlight.composeplayground.platform.Platform
import org.koin.dsl.bind
import org.koin.dsl.module

actual fun kotlinPlatformModule() = module {
    single { IosPlatform } bind Platform::class
}
