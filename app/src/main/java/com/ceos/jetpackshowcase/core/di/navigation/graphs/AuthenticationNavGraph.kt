package com.ceos.jetpackshowcase.core.di.navigation.graphs

import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ceos.jetpack_ui.screens.BlankScreen
import com.ceos.jetpackshowcase.authentification.domain.LandingScreenViewModel
import com.ceos.jetpackshowcase.authentification.presentation.screens.LandingScreen
import com.ceos.jetpackshowcase.core.di.navigation.Routes

fun NavGraphBuilder.authenticationNavGraph(route: String, onGraphSelected: () -> Unit) {
    navigation(
        startDestination = Routes.LANDING_SCREEN,
        route = route
    ){
        composable(Routes.LANDING_SCREEN){
            onGraphSelected()
            val vm:LandingScreenViewModel = hiltViewModel()
            LandingScreen(
                onLoginClicked = vm::login,
                onSignUpClicked = vm::signUp
            )
        }

        composable(Routes.LOGIN_SCREEN){
            BlankScreen(text = "Login", color = Color.Red)
        }

        composable(Routes.SIGN_UP_SCREEN){
            BlankScreen(text = "Sign up", color = Color.Green)
        }
    }
}