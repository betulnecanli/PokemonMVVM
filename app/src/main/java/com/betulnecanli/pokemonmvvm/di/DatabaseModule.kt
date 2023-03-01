package com.betulnecanli.pokemonmvvm.di

import android.content.Context
import androidx.room.Room
import com.betulnecanli.pokemonmvvm.data.local.PokedexDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): PokedexDatabase{
        return Room.databaseBuilder(
            context,
            PokedexDatabase::class.java,
            "pokemonDB"
        ).build()
    }

    @Singleton
    @Provides
    fun providePokemonDao(db : PokedexDatabase) = db.pokedexDao()


    @Singleton
    @Provides
    fun provideRemoteKey(db : PokedexDatabase) = db.remoteKeysDao()

}