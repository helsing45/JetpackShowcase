package com.ceos.jetpackshowcase.core.navigation.implementation

import androidx.navigation.NavOptionsBuilder
import com.ceos.jetpackshowcase.core.navigation.NavigationEvent
import com.ceos.jetpackshowcase.core.navigation.Navigator
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class NavigatorImpl : Navigator {
    private val navigationEvents = Channel<NavigationEvent>()
    override val destinations = navigationEvents.receiveAsFlow()

    override fun navigateUp(): Boolean {
        return navigationEvents.trySend(NavigationEvent.NavigateUp).isSuccess
    }

    override fun navigateTo(route: String, builder: NavOptionsBuilder.() -> Unit): Boolean {
        return navigationEvents.trySend(NavigationEvent.Destination(route, builder)).isSuccess
    }
}