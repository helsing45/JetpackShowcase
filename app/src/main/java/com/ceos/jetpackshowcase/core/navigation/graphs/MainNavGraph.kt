package com.ceos.jetpackshowcase.core.navigation.graphs

import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ceos.jetpack_ui.screens.BlankScreen
import com.ceos.jetpackshowcase.core.navigation.Routes

fun NavGraphBuilder.mainNavGraph(route:String,
                                 onGraphSelected: () -> Unit){
    navigation(
        startDestination = Routes.HOME_SCREEN,
        route = route
    ){
        composable(Routes.HOME_SCREEN){
            onGraphSelected()
            BlankScreen(
                text = "Home",
                testTag = "home_container",
                color = Color.Magenta
            )
        }
    }
}