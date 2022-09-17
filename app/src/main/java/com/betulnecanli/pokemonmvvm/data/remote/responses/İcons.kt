package com.betulnecanli.pokemonmvvm.data.remote.responses


import com.google.gson.annotations.SerializedName

data class İcons(
    @SerializedName("front_default")
    val frontDefault: String,
    @SerializedName("front_female")
    val frontFemale: Any
)