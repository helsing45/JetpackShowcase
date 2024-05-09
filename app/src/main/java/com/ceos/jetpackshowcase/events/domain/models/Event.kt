package com.ceos.jetpackshowcase.events.domain.models

data class Event(
    val id: String,
    val title: String,
    val description: String?,
)