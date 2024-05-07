package com.ceos.jetpackshowcase.authentification.domain

interface Authenticator {
    suspend fun signIn(email: String, password: String): Boolean
}