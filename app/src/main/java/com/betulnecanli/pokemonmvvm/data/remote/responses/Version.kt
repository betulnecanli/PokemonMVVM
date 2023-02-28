package com.betulnecanli.pokemonmvvm.data.remote.responses


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Version(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
) : Parcelable