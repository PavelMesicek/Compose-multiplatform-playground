package com.moonlight.composeplayground.app.logging

import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity
import com.moonlight.composeplayground.app.crashreporting.CrashlyticsReporter
import kotlin.coroutines.cancellation.CancellationException
import com.moonlight.composeplayground.network.graphql.result.NetworkError as GraphqlNetworkError
import com.moonlight.composeplayground.network.rest.result.NetworkError as RestNetworkError

/**
 * This object takes care of KMP logging setup.
 *
 * We utilize `Kermit`(https://kermit.touchlab.co/) logger for debug logging during development.
 */
internal object AppLogging {

    fun initialize(crashlyticsReporter: CrashlyticsReporter) {
        with(Logger) {
            setMinSeverity(Severity.Debug)
            setTag("KmpTemplate")
            setLogWriters(getPlatformLogWriters() + getCrashlyticsLogWriter(crashlyticsReporter))
        }
    }

    private fun getCrashlyticsLogWriter(crashlytics: CrashlyticsReporter) = CrashlyticsKermitLogWriter(
        crashlytics = crashlytics,
        minSeverity = Severity.Info,
        minCrashSeverity = Severity.Warn,
        isLoggable = ::throwableFilter,
    )

    private fun throwableFilter(throwable: Throwable): Boolean = when (throwable) {
        is GraphqlNetworkError.ConnectionError -> false
        is RestNetworkError.ConnectionError -> false
        is CancellationException -> false
        else -> true
    }
}

/**
 * Returns list of [LogWriter] instances that shared [Logger] instance should use.
 * This way, we can customize logging behaviour per-platform
 * (eg. Android should not use any log writers in production builds, etc).
 */
internal expect fun getPlatformLogWriters(): List<LogWriter>
