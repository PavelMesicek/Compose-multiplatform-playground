package com.moonlight.composeplayground.android.tools.binding

import com.moonlight.composeplayground.platform.binding.PlatformBindings
import com.moonlight.composeplayground.platform.binding.PlatformFirebaseCrashlytics

class PlatformBindingsImpl : PlatformBindings {
    override fun firebaseCrashlytics(): PlatformFirebaseCrashlytics = PlatformFirebaseCrashlyticsImpl()
}
