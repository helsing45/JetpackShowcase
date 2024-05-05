package com.ceos.jetpackshowcase.core.di.navigation

import android.content.Intent
import androidx.navigation.NavOptionsBuilder

sealed class NavigationEvent {
    data object NavigateUp : NavigationEvent()
    class IntentNavigation(val intent: Intent) : NavigationEvent()

    class Destination(
        val destination: String,
        val builder: NavOptionsBuilder.() -> Unit
    ) : NavigationEvent()
}