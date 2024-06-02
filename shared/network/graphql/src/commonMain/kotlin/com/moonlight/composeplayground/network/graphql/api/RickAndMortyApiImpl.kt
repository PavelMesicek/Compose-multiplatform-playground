package com.moonlight.composeplayground.network.graphql.api

import com.moonlight.composeplayground.network.graphql.GetEpisodesQuery
import com.moonlight.composeplayground.network.graphql.client.ApiManager
import com.moonlight.composeplayground.network.graphql.client.ApolloApiAdapter
import com.moonlight.composeplayground.network.graphql.fragment.EpisodeFragment
import com.moonlight.composeplayground.network.graphql.result.NetworkResult
import com.moonlight.composeplayground.network.graphql.result.map
import org.koin.core.annotation.Single

@Single
internal class RickAndMortyApiImpl(
    override val apiAdapter: ApolloApiAdapter,
) : RickAndMortyApi, ApiManager {

    override suspend fun getEpisodes(): NetworkResult<List<EpisodeFragment>> = executeQuery(GetEpisodesQuery())
        .map { data ->
            val results = data.episodes?.results ?: emptyList()
            results.mapNotNull { result -> result?.episodeFragment }
        }
}
