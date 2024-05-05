package com.ceos.jetpackshowcase.core.di.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.ceos.jetpackshowcase.core.di.navigation.Routes

fun NavGraphBuilder.mainNavGraph(route:String,
                                 onGraphSelected: (NavHostController) -> Unit){
    navigation(
        startDestination = Routes.HOME_SCREEN,
        route = route
    ){

    }
}