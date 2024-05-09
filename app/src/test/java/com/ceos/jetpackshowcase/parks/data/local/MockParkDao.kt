package com.ceos.jetpackshowcase.parks.data.local

import com.ceos.jetpackshowcase.parks.data.local.entities.ParkEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MockParkDao : ParkDao {
    private val _parks = mutableMapOf<String, ParkEntity>()
    private val parksFlow = MutableStateFlow(_parks.values.toList())

    override fun upsert(vararg parks: ParkEntity) {
        parks.forEach { park ->
            _parks[park.id] = park
        }
        parksFlow.update {
            _parks.values.toList()
        }
    }

    override fun getParks() = parksFlow

    fun tearDown() {
        _parks.clear()
    }


}