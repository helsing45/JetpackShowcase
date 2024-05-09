package com.ceos.jetpackshowcase.parks.data.mappers

import com.ceos.jetpackshowcase.error_handling.UnexpectedNullWhileMappingError
import com.ceos.jetpackshowcase.parks.data.local.entities.ParkEntity
import com.ceos.jetpackshowcase.parks.data.remote.dtos.ParkDto
import com.ceos.jetpackshowcase.parks.domain.models.Park

fun ParkEntity.toDomain() = Park(
    id = this.id,
    name = this.name,
    description = this.description,
    lat = this.lat,
    lng = this.lng
)

fun ParkDto.toEntity() =
    ParkEntity(
        id = this.id ?: throw UnexpectedNullWhileMappingError("id is null"),
        name = this.name
            ?: throw UnexpectedNullWhileMappingError("name is null"),
        description = this.description,
        lat = this.latitude?.toDouble() ?: Double.NaN,
        lng = this.longitude?.toDouble() ?: Double.NaN
    )
