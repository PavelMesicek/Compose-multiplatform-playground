package com.moonlight.composeplayground.network.graphql.cache

/**
 * Interface that allows direct access to network cache layer.
 */
interface NetworkCache {

    /**
     * Clears all network caches.
     */
    fun clear()
}
