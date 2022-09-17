package com.betulnecanli.pokemonmvvm.di

import com.betulnecanli.pokemonmvvm.network.PokedexApi
import com.betulnecanli.pokemonmvvm.repository.PokedexRepository
import com.betulnecanli.pokemonmvvm.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


            @Provides
            @Singleton
            fun provideOkHttpClient() : OkHttpClient{
                return OkHttpClient.Builder()
                    .build()
            }

            @Provides
            @Singleton
            fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {

                return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create() )
                    .build()
            }


            @Singleton
            @Provides
            fun providePokedexApi(retrofit : Retrofit) : PokedexApi{
                return retrofit.create(PokedexApi::class.java)
            }

            @Singleton
            @Provides
            fun providePokemonRepository(
                api : PokedexApi
            ) = PokedexRepository(api)


}