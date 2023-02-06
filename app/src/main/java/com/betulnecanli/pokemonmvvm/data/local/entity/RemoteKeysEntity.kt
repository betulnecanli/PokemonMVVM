package com.betulnecanli.pokemonmvvm.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RemoteKeysEntity(
    @PrimaryKey val id :Int
) {
}