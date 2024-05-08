package com.ceos.jetpackshowcase.parks.domain.models

import com.ceos.jetpackshowcase.error_handling.Outcome

sealed interface ParkError: Outcome.Error{
    data class NetworkError(val code:Int, val message:String): ParkError

}