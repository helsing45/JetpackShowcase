package com.ceos.jetpackshowcase.parks.data

import com.ceos.jetpackshowcase.core.DispatcherProvider
import com.ceos.jetpackshowcase.core.logger.Logger
import com.ceos.jetpackshowcase.error_handling.UnexpectedNullWhileMappingError
import com.ceos.jetpackshowcase.parks.data.local.ParkDao
import com.ceos.jetpackshowcase.parks.data.mappers.toDomain
import com.ceos.jetpackshowcase.parks.data.mappers.toEntity
import com.ceos.jetpackshowcase.parks.data.remote.ParksApi
import com.ceos.jetpackshowcase.parks.domain.models.Park
import com.ceos.jetpackshowcase.parks.domain.repositories.ParkRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ParkRepositoryImpl(
    private val logger: Logger,
    private val dispatcherProvider: DispatcherProvider,
    private val localDataSource: ParkDao,
    private val remoteDataSource: ParksApi
) : ParkRepository {

    override fun getParks(): Flow<List<Park>> {
        fetchParks()
        return localDataSource.getParks().map { entities ->
            entities.map { it.toDomain() }
        }

    }

    private fun fetchParks() {
        CoroutineScope(dispatcherProvider.io()).launch {
            try {
                val result = remoteDataSource.getParks()
                val entities = result.value?.mapNotNull {
                    try {
                        it.toEntity()
                    } catch (e: UnexpectedNullWhileMappingError) {
                        logger.e(e, "Failed to map park: ${e.message}")
                        null
                    }
                } ?: emptyList()
                localDataSource.upsert(*entities.toTypedArray())
            } catch (e: Exception) {
                logger.e(e, "Failed to fetch parks")
            }
        }
    }
}


