package com.ceos.jetpackshowcase.parks.data.mappers

import com.ceos.jetpackshowcase.core.extensions.nullIfEmpty
import com.ceos.jetpackshowcase.core.utils.mapFieldOrThrow
import com.ceos.jetpackshowcase.parks.data.local.entities.ParkEntity
import com.ceos.jetpackshowcase.parks.data.remote.dtos.ParkDto
import com.ceos.jetpackshowcase.parks.domain.models.Park

fun ParkEntity.toDomain() = Park(
    id = id,
    name = name,
    description = description,
    lat = lat,
    lng = lng
)

fun ParkDto.toEntity() =
    ParkEntity(
        id = mapFieldOrThrow(id, "id"),
        name = mapFieldOrThrow(name, "name"),
        description = description,
        lat = mapFieldOrThrow(latitude.nullIfEmpty()?.toDouble(), "latitude"),
        lng = mapFieldOrThrow(longitude.nullIfEmpty()?.toDouble(), "longitude")
    )
