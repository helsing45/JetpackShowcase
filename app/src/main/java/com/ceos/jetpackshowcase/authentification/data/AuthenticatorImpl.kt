package com.ceos.jetpackshowcase.authentification.data

import androidx.compose.runtime.mutableStateOf
import com.ceos.jetpackshowcase.authentification.domain.Authenticator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class AuthenticatorImpl : Authenticator {
    private val currentUser = mutableStateOf<User?>(null)

    private val auth: FirebaseAuth by lazy {
        Firebase.auth
    }

    override suspend fun signIn(email: String, password: String): Boolean {
        val result = auth.signInWithEmailAndPassword(email, password).await()
        currentUser.value = User(
            id = result.user!!.uid,
            displayName = result.user?.displayName
        )
        return true
    }
}