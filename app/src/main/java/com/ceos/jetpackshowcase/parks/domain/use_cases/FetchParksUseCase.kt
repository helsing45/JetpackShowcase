package com.ceos.jetpackshowcase.parks.domain.use_cases

import com.ceos.jetpackshowcase.parks.domain.models.Park
import com.ceos.jetpackshowcase.parks.domain.repositories.ParkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchParksUseCase @Inject constructor(
    private val parkRepository: ParkRepository
) {
    fun getParks(): Flow<List<Park>>{
        return parkRepository.getParks()
    }
}