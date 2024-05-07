package com.ceos.jetpackshowcase.core.navigation

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.flow.Flow

interface Navigator {
    val destinations: Flow<NavigationEvent>
    fun navigateUp(): Boolean

    fun navigateTo(
        route: String,
        builder: NavOptionsBuilder.() -> Unit = {
            launchSingleTop = true
        }
    ): Boolean
}