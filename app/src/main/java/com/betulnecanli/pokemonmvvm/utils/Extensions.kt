package com.betulnecanli.pokemonmvvm.utils


fun String.findID() = this.substringAfter("pokemon").replace("/","").toInt()

fun String.getImageOfPoke() : String {
    val id = this.findID()
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png"
}