package com.moonlight.composeplayground.android.tools.binding

import com.moonlight.composeplayground.platform.binding.PlatformFirebaseCrashlytics

class PlatformFirebaseCrashlyticsImpl : PlatformFirebaseCrashlytics {

    override fun logMessage(message: String) {
        // TODO Uncomment when Firebase Crashlytics is added as dependency
        // Firebase.crashlytics.log(message)
    }

    override fun sendNonFatalException(error: Throwable) {
        // TODO Uncomment when Firebase Crashlytics is added as dependency
        // Firebase.crashlytics.recordException(error)
    }
}
