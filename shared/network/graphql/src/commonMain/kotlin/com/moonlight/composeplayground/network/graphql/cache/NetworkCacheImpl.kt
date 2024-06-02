package com.moonlight.composeplayground.network.graphql.cache

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.apolloStore
import org.koin.core.annotation.Single

@Single
internal class NetworkCacheImpl(
    private val apolloClient: ApolloClient,
) : NetworkCache {

    override fun clear() {
        apolloClient.apolloStore.clearAll()
    }
}
