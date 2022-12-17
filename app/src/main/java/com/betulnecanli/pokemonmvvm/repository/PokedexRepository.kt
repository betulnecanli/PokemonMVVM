package com.betulnecanli.pokemonmvvm.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.betulnecanli.pokemonmvvm.data.remote.responses.Pokemon
import com.betulnecanli.pokemonmvvm.data.remote.responses.PokemonList
import com.betulnecanli.pokemonmvvm.network.PokedexApi
import com.betulnecanli.pokemonmvvm.paging.PokedexPagingSource
import com.betulnecanli.pokemonmvvm.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class PokedexRepository @Inject constructor(
    private val api : PokedexApi
){

    fun getPokemonList() =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
                    ),
            pagingSourceFactory = {PokedexPagingSource(api)}
        ).liveData

}

   /* suspend fun getPokemonList(limit : Int, offset : Int) : Resource<PokemonList>{
        val response = try {
            api.getPokedexList(limit,offset)
        }
        catch (e : Exception){
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemon(name : String) : Resource<Pokemon>{
        val response = try {
            api.getPokemonDetail(name)
        }
        catch (e : Exception){
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }*/
