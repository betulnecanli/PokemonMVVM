package com.betulnecanli.pokemonmvvm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.betulnecanli.pokemonmvvm.data.local.entity.PokedexEntity
import com.betulnecanli.pokemonmvvm.data.local.entity.RemoteKeysEntity

@Database(entities = [PokedexEntity::class, RemoteKeysEntity::class], version = 1)
abstract class PokedexDatabase : RoomDatabase() {
}