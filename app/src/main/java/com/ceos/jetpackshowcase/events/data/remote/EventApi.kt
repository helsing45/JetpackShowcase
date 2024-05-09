package com.ceos.jetpackshowcase.events.data.remote

import com.ceos.jetpackshowcase.events.data.remote.dto.EventsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface EventApi {

    @GET("events")
    suspend fun getEvents(
        @Query("pageSize") pageSize: Int = 10,
        @Query("pageNumber") page: Int
    ): EventsDto
}