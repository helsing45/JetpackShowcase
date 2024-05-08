package com.ceos.jetpackshowcase.parks.data.remote.dtos


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ParkDto(
    @SerialName("id")
    val id: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("designation")
    val designation: String?,
    @SerialName("directionsInfo")
    val directionsInfo: String?,
    @SerialName("fullName")
    val fullName: String?,
    @SerialName("latitude")
    val latitude: String?,
    @SerialName("longitude")
    val longitude: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("parkCode")
    val parkCode: String?,
    @SerialName("states")
    val states: String?,
    @SerialName("url")
    val url: String?
)