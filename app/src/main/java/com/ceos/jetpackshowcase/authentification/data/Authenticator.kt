package com.ceos.jetpackshowcase.authentification.data

interface Authenticator {
    suspend fun signIn(email: String, password: String): Boolean
}