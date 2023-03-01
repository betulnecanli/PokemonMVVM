package com.betulnecanli.pokemonmvvm.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.betulnecanli.pokemonmvvm.data.local.entity.RemoteKeysEntity


@Dao
interface RemoteKeysDao {
    @Query("SELECT * FROM remoteKeyTable WHERE id = :id")
    suspend fun getRemoteKey(id : Int): RemoteKeysEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKey: List<RemoteKeysEntity>)

    @Query("DELETE FROM remoteKeyTable")
    suspend fun deleteAllRemoteKeys()
}