package com.ceos.jetpackshowcase.parks.domain.repositories

import com.ceos.jetpackshowcase.error_handling.Outcome
import com.ceos.jetpackshowcase.parks.domain.models.Park
import com.ceos.jetpackshowcase.parks.domain.models.ParkError
import kotlinx.coroutines.flow.Flow

interface ParkRepository {
    fun getParks(): Flow<Outcome<List<Park>, ParkError>>
}