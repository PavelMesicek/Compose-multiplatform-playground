package com.moonlight.composeplayground.network.rest.ext

import com.moonlight.composeplayground.network.rest.result.NetworkError

/**
 * Checks whether given [Throwable] is [NetworkError.ConnectionError]
 */
fun Throwable.isConnectionError(): Boolean = this is NetworkError.ConnectionError
