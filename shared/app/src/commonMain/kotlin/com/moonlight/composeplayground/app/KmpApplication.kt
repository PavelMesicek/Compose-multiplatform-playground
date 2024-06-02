package com.moonlight.composeplayground.app

import com.moonlight.composeplayground.app.crashreporting.AppCrashReporting
import com.moonlight.composeplayground.app.crashreporting.CrashlyticsReporter
import com.moonlight.composeplayground.app.injection.AppInjection
import com.moonlight.composeplayground.app.logging.AppLogging
import com.moonlight.composeplayground.platform.binding.PlatformBindings
import org.koin.dsl.KoinAppDeclaration

/**
 * Shared KMP entrypoint.
 *
 * Initializes injection framework,
 */
object KmpApplication {

    fun initializeSharedApplication(
        platformBindings: PlatformBindings,
        appDeclaration: KoinAppDeclaration? = null,
    ) {
        val crashlyticsReporter = CrashlyticsReporter(platformBindings.firebaseCrashlytics())

        AppInjection.initializeInjection(
            platformBindings = platformBindings,
            appDeclaration = appDeclaration,
        )
        AppCrashReporting.initialize(crashlyticsReporter)
        AppLogging.initialize(crashlyticsReporter)
    }
}
