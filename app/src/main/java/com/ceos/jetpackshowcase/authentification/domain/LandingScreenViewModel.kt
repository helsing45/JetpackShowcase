package com.ceos.jetpackshowcase.authentification.domain

import androidx.lifecycle.ViewModel
import com.ceos.jetpackshowcase.core.di.navigation.Navigator
import com.ceos.jetpackshowcase.core.di.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LandingScreenViewModel
@Inject constructor(private val navigator: Navigator) : ViewModel() {

    fun login(){
        navigator.navigateTo(Routes.LOGIN_SCREEN)
    }
    fun signUp(){
        navigator.navigateTo(Routes.SIGN_UP_SCREEN)
    }
}