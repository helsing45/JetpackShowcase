package com.ceos.jetpackshowcase.parks.domain.models

data class Park(
    val id: String,
    val name: String,
    val description: String?,
    val lat: Double,
    val lng: Double
)
