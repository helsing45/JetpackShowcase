package com.ceos.jetpackshowcase.authentification.domain

class AuthenticatorImpl : Authenticator {
    override suspend fun signIn(email: String, password: String): Boolean {
        return email == "test@gmail.com" && password == "password"
    }

}
