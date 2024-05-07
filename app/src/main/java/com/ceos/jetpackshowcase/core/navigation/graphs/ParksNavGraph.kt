package com.ceos.jetpackshowcase.core.navigation.graphs

import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ceos.jetpack_ui.screens.BlankScreen
import com.ceos.jetpackshowcase.core.navigation.Routes

fun NavGraphBuilder.parkNavGraph(
    route: String
) {
   navigation(startDestination = Routes.PARKS_SCREEN, route = route) {

       composable(Routes.PARKS_SCREEN){
           BlankScreen(text = "Parks", color = Color.Magenta)
       }
   }
}