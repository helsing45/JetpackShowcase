package com.ceos.jetpackshowcase.authentification.domain

import com.ceos.jetpackshowcase.authentification.data.Authenticator
import com.ceos.jetpackshowcase.authentification.domain.AuthenticationError.InvalidCredential
import com.ceos.jetpackshowcase.authentification.domain.AuthenticationError.UnknownError
import com.ceos.jetpackshowcase.error_handling.Outcome
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class SignInWithEmailAndPasswordUseCase @Inject constructor(
    private val authenticator: Authenticator
) {

    fun signIn(email: String, password: String) = flow {

        try {
            if (authenticator.signIn(email, password)) {
                emit(Outcome.of(true))
            } else {
                emit(Outcome.of(InvalidCredential))
            }
        } catch (e: Exception) {
            if (e is FirebaseAuthInvalidCredentialsException)
                emit(Outcome.of(InvalidCredential))
            else
                emit(Outcome.of(UnknownError))

        }
    }


}