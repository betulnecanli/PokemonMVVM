package com.betulnecanli.pokemonmvvm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.betulnecanli.pokemonmvvm.data.local.entity.RemoteKeysEntity
import com.betulnecanli.pokemonmvvm.data.remote.responses.Pokemon

@Database(entities = [Pokemon::class, RemoteKeysEntity::class], version = 1)
abstract class PokedexDatabase : RoomDatabase() {

    abstract fun pokedexDao() : PokedexDao
    abstract fun remoteKeysDao(): RemoteKeysDao

}