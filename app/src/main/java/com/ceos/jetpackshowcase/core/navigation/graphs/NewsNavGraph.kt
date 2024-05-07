package com.ceos.jetpackshowcase.core.navigation.graphs

import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ceos.jetpack_ui.screens.BlankScreen
import com.ceos.jetpackshowcase.core.navigation.Routes

fun NavGraphBuilder.newsNavGraph(
    route: String
) {
   navigation(startDestination = Routes.NEWS_SCREEN, route = route) {
       
       composable(Routes.NEWS_SCREEN){
           BlankScreen(text = "News", color = Color.Cyan)
       }
   } 
}