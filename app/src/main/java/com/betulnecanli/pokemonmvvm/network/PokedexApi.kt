package com.betulnecanli.pokemonmvvm.network

import com.betulnecanli.pokemonmvvm.data.remote.responses.Pokemon
import com.betulnecanli.pokemonmvvm.data.remote.responses.PokemonList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokedexApi {

    @GET("pokemon")
    suspend fun getPokedexList(
        @Query("limit") limit : Int = 20,
        @Query("offset") offset : Int
    ) : Response<PokemonList>




    @GET("/pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name : String
    ) : Response<Pokemon>
}