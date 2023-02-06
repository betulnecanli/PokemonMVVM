package com.betulnecanli.pokemonmvvm.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.betulnecanli.pokemonmvvm.data.remote.responses.*
import com.google.gson.annotations.SerializedName

@Entity
data class PokedexEntity(
    val abilities: List<Ability>,
    val baseExperience: Int,
    val forms: List<Form>,
    val gameIndices: List<Gameİndice>,
    val height: Int,
    val heldItems: List<Any>,
    @PrimaryKey
    val id: Int,
    val isDefault: Boolean,
    val locationAreaEncounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val pastTypes: List<Any>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
) {
}