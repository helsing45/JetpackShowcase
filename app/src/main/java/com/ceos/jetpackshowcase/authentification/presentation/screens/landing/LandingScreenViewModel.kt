package com.ceos.jetpackshowcase.authentification.presentation.screens.landing

import androidx.lifecycle.ViewModel
import com.ceos.jetpackshowcase.core.navigation.Navigator
import com.ceos.jetpackshowcase.core.navigation.Routes
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