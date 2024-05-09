package com.ceos.jetpackshowcase.events.data.mappers

import com.ceos.jetpackshowcase.core.utils.mapFieldOrThrow
import com.ceos.jetpackshowcase.events.data.local.entities.EventEntity
import com.ceos.jetpackshowcase.events.data.remote.dto.EventsDto.EventDto
import com.ceos.jetpackshowcase.events.domain.models.Event

fun EventEntity.toDomain() = Event(
    id = id,
    title = title,
    description = description,
)

fun EventDto.toEntity() = EventEntity(
    id = mapFieldOrThrow(id,"id"),
    title = mapFieldOrThrow(title,"title"),
    description = description,
)
