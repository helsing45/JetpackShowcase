package com.ceos.jetpackshowcase.parks.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity("park")
data class ParkEntity(
    @PrimaryKey val id :String = UUID.randomUUID().toString(),
    val name: String,
    val description: String?,
    val lat: Double,
    val lng: Double
)