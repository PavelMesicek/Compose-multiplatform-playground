package com.moonlight.composeplayground.app.crashreporting

import com.moonlight.composeplayground.platform.binding.PlatformFirebaseCrashlytics

/**
 * Class responsible for recording crashlytics errors using provided [PlatformFirebaseCrashlytics] binding.
 */
internal actual class CrashlyticsReporter actual constructor(private val crashlytics: PlatformFirebaseCrashlytics) {
    actual fun logMessage(message: String) = crashlytics.logMessage(message)
    actual fun sendNonFatalException(throwable: Throwable) = crashlytics.sendNonFatalException(throwable)
}
