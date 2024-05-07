package com.ceos.jetpackshowcase.core.navigation.graphs

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ceos.jetpackshowcase.core.navigation.Routes
import com.ceos.jetpackshowcase.ui.component.BottomNavigationBar

fun NavGraphBuilder.mainNavGraph(
    route: String,
    onGraphSelected: () -> Unit
) {
    composable(route) {
        val navController = rememberNavController()
        onGraphSelected()

        Scaffold(
            bottomBar = {
                BottomNavigationBar(navController)
            }
        ) {
            NavHost(
                modifier = Modifier.padding(it),
                navController = navController,
                route = Routes.MAIN_GRAPH,
                startDestination = Routes.PARKS_GRAPH
            ) {
                parkNavGraph(Routes.PARKS_GRAPH)

                newsNavGraph(Routes.NEWS_GRAPH)

                profileNavGraph(Routes.PROFILE_GRAPH)
            }

        }
    }

}