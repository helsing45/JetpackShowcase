package com.ceos.jetpackshowcase.parks.data.mappers

import com.ceos.jetpackshowcase.error_handling.UnexpectedNullWhileMappingError
import com.ceos.jetpackshowcase.parks.data.local.entities.ParkEntity
import com.ceos.jetpackshowcase.parks.data.remote.dtos.ParkDto
import com.ceos.jetpackshowcase.parks.domain.models.Park

class ParkMapper {
    fun entityToDomain(entity: ParkEntity) = Park(
        id = entity.id,
        name = entity.name,
        description = entity.description,
        lat = entity.lat,
        lng = entity.lng
    )

    fun remoteToEntity(dto: ParkDto) =
        ParkEntity(
            id = dto.id ?: throw UnexpectedNullWhileMappingError("id is null"),
            name = dto.name
                ?: throw UnexpectedNullWhileMappingError("name is null"),
            description = dto.description,
            lat = dto.latitude?.toDouble() ?: Double.NaN,
            lng = dto.longitude?.toDouble() ?: Double.NaN
        )
}