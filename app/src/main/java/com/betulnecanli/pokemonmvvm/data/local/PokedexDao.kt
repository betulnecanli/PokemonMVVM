package com.betulnecanli.pokemonmvvm.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.betulnecanli.pokemonmvvm.data.remote.responses.Pokemon

@Dao
interface PokedexDao {

    @Query("SELECT * FROM PokemonTable ORDER BY id ASC")
    fun getAllCharacters(): PagingSource<Int, Pokemon>

    @Query("SELECT * FROM PokemonTable WHERE id =:id")
    fun getSelectedCharacter(id:Int): Pokemon

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacter(characters : List<Pokemon>)

    @Query("DELETE FROM PokemonTable")
    suspend fun deleteAll()

}