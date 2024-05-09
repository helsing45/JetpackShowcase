package com.ceos.jetpackshowcase.core.navigation.graphs

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ceos.jetpackshowcase.core.navigation.Routes
import com.ceos.jetpackshowcase.events.presentation.screens.events.EventsScreen

fun NavGraphBuilder.eventsNavGraph(
    route: String
) {
   navigation(startDestination = Routes.EVENTS_SCREEN, route = route) {
       
       composable(Routes.EVENTS_SCREEN){
           EventsScreen(vm = hiltViewModel())
       }
   } 
}