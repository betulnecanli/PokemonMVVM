package com.betulnecanli.pokemonmvvm.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remoteKeyTable")
data class RemoteKeysEntity(
    @PrimaryKey val id :Int,
                val prevPage : Int?,
                val nextPage : Int?
) {
}