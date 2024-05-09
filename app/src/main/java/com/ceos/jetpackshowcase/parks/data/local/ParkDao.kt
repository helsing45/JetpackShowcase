package com.ceos.jetpackshowcase.parks.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ceos.jetpackshowcase.parks.data.local.entities.ParkEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ParkDao {

    @Upsert
    fun upsert(vararg parks: ParkEntity)

    @Query("SELECT * FROM parks")
    fun getParks(): Flow<List<ParkEntity>>
}