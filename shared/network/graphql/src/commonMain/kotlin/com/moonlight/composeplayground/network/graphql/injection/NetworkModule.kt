package com.moonlight.composeplayground.network.graphql.injection

import com.apollographql.apollo3.ApolloClient
import com.moonlight.composeplayground.network.graphql.client.ApolloClientFactory
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.moonlight.composeplayground.network.graphql")
class NetworkGraphqlModule {
    @Single
    fun apolloClient(factory: ApolloClientFactory): ApolloClient = factory.create()
}
