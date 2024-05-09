package com.ceos.jetpackshowcase

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ceos.jetpackshowcase.core.navigation.NavigationEvent
import com.ceos.jetpackshowcase.core.navigation.Navigator
import com.ceos.jetpackshowcase.core.navigation.Routes
import com.ceos.jetpackshowcase.core.navigation.graphs.authenticationNavGraph
import com.ceos.jetpackshowcase.core.navigation.graphs.mainNavGraph
import com.ceos.jetpackshowcase.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(
                dynamicColor = false
            ) {

                val baseNavController = rememberNavController()
                var currentNavController by remember { mutableStateOf(baseNavController) }
                LaunchedEffect(navigator) {
                    navigator.destinations.collectLatest { event ->
                        when (event) {
                            is NavigationEvent.Destination -> {
                                try {
                                    currentNavController.navigate(event.destination, event.builder)
                                } catch (e: IllegalArgumentException) {
                                    Toast.makeText(
                                        this@MainActivity,
                                        "No path to ${event.destination} has been found",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }

                            is NavigationEvent.IntentNavigation -> startActivity(event.intent)
                            is NavigationEvent.NavigateUp -> currentNavController.navigateUp()
                        }
                    }

                }

                NavHost(
                    navController = baseNavController,
                    startDestination = Routes.MAIN_GRAPH
                ) {
                    authenticationNavGraph(Routes.AUTHENTICATION_GRAPH) {
                        currentNavController = baseNavController
                    }
                    mainNavGraph(Routes.MAIN_GRAPH) {
                        currentNavController = baseNavController
                    }
                }
            }
        }
    }
}