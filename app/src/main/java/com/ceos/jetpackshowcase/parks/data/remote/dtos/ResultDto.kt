package com.ceos.jetpackshowcase.parks.data.remote.dtos


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultDto<T>(
    @SerialName("data")
    val value: List<T>?,
    @SerialName("limit")
    val limit: String?,
    @SerialName("start")
    val start: String?,
    @SerialName("total")
    val total: String?
)