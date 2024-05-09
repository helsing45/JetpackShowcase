package com.ceos.jetpackshowcase.parks.domain.repositories

import com.ceos.jetpackshowcase.parks.domain.models.Park
import kotlinx.coroutines.flow.Flow

interface ParkRepository {
    fun getParks(): Flow<List<Park>>
}