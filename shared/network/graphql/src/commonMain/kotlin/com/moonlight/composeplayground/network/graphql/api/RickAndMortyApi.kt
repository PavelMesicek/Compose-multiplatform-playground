package com.moonlight.composeplayground.network.graphql.api

import com.moonlight.composeplayground.network.graphql.fragment.EpisodeFragment
import com.moonlight.composeplayground.network.graphql.result.NetworkResult

interface RickAndMortyApi {
    suspend fun getEpisodes(): NetworkResult<List<EpisodeFragment>>
}
