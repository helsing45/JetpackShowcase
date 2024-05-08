package com.ceos.jetpackshowcase.parks.data

import android.util.Log
import com.ceos.jetpackshowcase.error_handling.Outcome
import com.ceos.jetpackshowcase.error_handling.UnexpectedNullWhileMappingError
import com.ceos.jetpackshowcase.parks.data.remote.ParksApi
import com.ceos.jetpackshowcase.parks.data.remote.dtos.ParkDto
import com.ceos.jetpackshowcase.parks.domain.models.Park
import com.ceos.jetpackshowcase.parks.domain.models.ParkError
import com.ceos.jetpackshowcase.parks.domain.models.ParkError.NetworkError
import com.ceos.jetpackshowcase.parks.domain.repositories.ParkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ParkRepositoryImpl(
    private val remoteDataSource: ParksApi
) : ParkRepository {

    override fun getParks(): Flow<Outcome<List<Park>, ParkError>> = flow {
        try {
            val result = remoteDataSource.getParks()
            val parks = result.value.mapToModel().orEmpty()
            emit(Outcome.of(parks))
        } catch (e: Exception) {
            emit(Outcome.of(NetworkError(400, e.message.orEmpty())))
        }


    }
}

private fun List<ParkDto>?.mapToModel(): List<Park>? {
    return this?.mapNotNull {
        try {
            Park(
                id = it.id ?: throw UnexpectedNullWhileMappingError("id is null"),
                name = it.name ?: throw UnexpectedNullWhileMappingError("name is null"),
                description = it.description
                    ?: throw UnexpectedNullWhileMappingError("description is null"),
                lat = it.latitude?.toDouble()
                    ?: throw UnexpectedNullWhileMappingError("latitude is null"),
                lng = it.longitude?.toDouble()
                    ?: throw UnexpectedNullWhileMappingError("longitude is null")
            )
        } catch (e: Exception) {
            Log.w("ParkRepositoryImpl", "Failed to map park: ${e.message}", e)
            null
        }
    }
}
