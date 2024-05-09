package com.ceos.jetpackshowcase.core.local_storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ceos.jetpackshowcase.events.data.local.EventDao
import com.ceos.jetpackshowcase.events.data.local.entities.EventEntity
import com.ceos.jetpackshowcase.parks.data.local.ParkDao
import com.ceos.jetpackshowcase.parks.data.local.entities.ParkEntity

@Database(
    entities = [ParkEntity::class,
               EventEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun parkDao(): ParkDao

    abstract fun eventDao(): EventDao

}