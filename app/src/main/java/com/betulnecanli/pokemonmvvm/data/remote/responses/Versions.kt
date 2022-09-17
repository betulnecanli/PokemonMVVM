package com.betulnecanli.pokemonmvvm.data.remote.responses


import com.google.gson.annotations.SerializedName

data class Versions(
    @SerializedName("generation-v")
    val generationV: GenerationV,
    @SerializedName("generation-vi")
    val generationVi: GenerationVi,
    @SerializedName("generation-vii")
    val generationVii: GenerationVii,
    @SerializedName("generation-viii")
    val generationViii: GenerationViii,
    @SerializedName("generation-i")
    val generationİ: Generationİ,
    @SerializedName("generation-ii")
    val generationİi: Generationİi,
    @SerializedName("generation-iii")
    val generationİii: Generationİii,
    @SerializedName("generation-iv")
    val generationİv: Generationİv
)