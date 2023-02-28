package com.betulnecanli.pokemonmvvm.data.remote.responses


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gameİndice(
    @SerializedName("game_index")
    val gameİndex: Int,
    @SerializedName("version")
    val version: Version
) : Parcelable