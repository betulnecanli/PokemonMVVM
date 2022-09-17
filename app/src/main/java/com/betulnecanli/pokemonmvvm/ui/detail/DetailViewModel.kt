package com.betulnecanli.pokemonmvvm.ui.detail

import androidx.lifecycle.ViewModel
import com.betulnecanli.pokemonmvvm.repository.PokedexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    val repository : PokedexRepository
) : ViewModel() {
}