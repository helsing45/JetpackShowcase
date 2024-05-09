package com.ceos.jetpackshowcase.events.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class EventEntity(
    val id: String,
    val title: String,
    val description: String?,
    @PrimaryKey(autoGenerate = true)
    val localDbId: Int = 0
)