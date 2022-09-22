package com.betulnecanli.pokemonmvvm.ui.list

import androidx.lifecycle.ViewModel
import com.betulnecanli.pokemonmvvm.repository.PokedexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    val repo : PokedexRepository
): ViewModel() {

    val pokedexList = repo.getPokemonList()
}