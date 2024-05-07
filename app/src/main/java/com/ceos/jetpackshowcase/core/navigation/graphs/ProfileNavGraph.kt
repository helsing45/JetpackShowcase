package com.ceos.jetpackshowcase.core.navigation.graphs

import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ceos.jetpack_ui.screens.BlankScreen
import com.ceos.jetpackshowcase.core.navigation.Routes

fun NavGraphBuilder.profileNavGraph(
    route: String
) {
   navigation(startDestination = Routes.PROFILE_SCREEN, route = route) {
       
       composable(Routes.PROFILE_SCREEN){
           BlankScreen(text = "Profile", color = Color.Blue)
       }
   } 
}