package com.ceos.jetpackshowcase.authentification.domain

import com.ceos.jetpackshowcase.authentification.data.Authenticator

class AuthenticatorImpl : Authenticator {
    override suspend fun signIn(email: String, password: String): Boolean {
        return email == "test@gmail.com" && password == "password"
    }

}
