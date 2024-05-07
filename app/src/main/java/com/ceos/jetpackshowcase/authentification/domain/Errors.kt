package com.ceos.jetpackshowcase.authentification.domain

import com.ceos.jetpackshowcase.error_handling.Outcome

sealed interface AuthenticationError : Outcome.Error {
    data object UnknownError : AuthenticationError
    data object InvalidCredential : AuthenticationError

}