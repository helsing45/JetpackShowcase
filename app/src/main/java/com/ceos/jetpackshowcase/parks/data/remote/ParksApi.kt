package com.ceos.jetpackshowcase.parks.data.remote

import com.ceos.jetpackshowcase.parks.data.remote.dtos.ParkDto
import com.ceos.jetpackshowcase.parks.data.remote.dtos.ResultDto
import retrofit2.http.GET

interface ParksApi {

    @GET("parks")
    suspend fun getParks(): ResultDto<ParkDto>

}
