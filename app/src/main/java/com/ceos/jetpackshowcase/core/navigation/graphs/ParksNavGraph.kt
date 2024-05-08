package com.ceos.jetpackshowcase.core.navigation.graphs

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ceos.jetpackshowcase.core.navigation.Routes
import com.ceos.jetpackshowcase.parks.presentation.screens.ParksScreen

fun NavGraphBuilder.parkNavGraph(
    route: String
) {
   navigation(startDestination = Routes.PARKS_SCREEN, route = route) {

       composable(Routes.PARKS_SCREEN){
           ParksScreen(hiltViewModel())
       }
   }
}