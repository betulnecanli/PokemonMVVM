package com.betulnecanli.pokemonmvvm.data.pagingsource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.betulnecanli.pokemonmvvm.data.local.PokedexDatabase
import com.betulnecanli.pokemonmvvm.data.local.entity.PokedexEntity
import com.betulnecanli.pokemonmvvm.network.PokedexApi
import javax.inject.Inject


@OptIn(ExperimentalPagingApi::class)
class PokedexRemoteMediator @Inject constructor(
    private val PokedexApi : PokedexApi,
    private val pokedexDB : PokedexDatabase
): RemoteMediator<Int, PokedexEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PokedexEntity>
    ): MediatorResult {
        TODO("Not yet implemented")
    }

}