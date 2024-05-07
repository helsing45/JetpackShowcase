package com.ceos.jetpackshowcase.core.navigation.graphs

import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ceos.jetpack_ui.screens.BlankScreen
import com.ceos.jetpackshowcase.authentification.presentation.screens.landing.LandingScreenViewModel
import com.ceos.jetpackshowcase.authentification.presentation.screens.landing.LandingScreen
import com.ceos.jetpackshowcase.authentification.presentation.screens.login.LoginScreen
import com.ceos.jetpackshowcase.core.navigation.Routes

fun NavGraphBuilder.authenticationNavGraph(route: String, onGraphSelected: () -> Unit) {
    navigation(
        startDestination = Routes.LANDING_SCREEN,
        route = route
    ){
        composable(Routes.LANDING_SCREEN){
            onGraphSelected()
            val vm: LandingScreenViewModel = hiltViewModel()
            LandingScreen(
                onLoginClicked = vm::login,
                onSignUpClicked = vm::signUp
            )
        }

        composable(Routes.LOGIN_SCREEN){
            LoginScreen(vm = hiltViewModel())
        }

        composable(Routes.SIGN_UP_SCREEN){
            BlankScreen(text = "Sign up", color = Color.Green)
        }
    }
}