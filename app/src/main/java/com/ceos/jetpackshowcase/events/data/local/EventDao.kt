package com.ceos.jetpackshowcase.events.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ceos.jetpackshowcase.events.data.local.entities.EventEntity

@Dao
interface EventDao {

    @Upsert
    suspend fun upsert(vararg events: EventEntity)

    @Query("SELECT * FROM events")
    fun pagingSource(): PagingSource<Int, EventEntity>

    @Query("DELETE FROM events")
    suspend fun clearEvents()


}