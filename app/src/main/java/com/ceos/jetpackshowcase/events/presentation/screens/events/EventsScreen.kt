package com.ceos.jetpackshowcase.events.presentation.screens.events

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.ceos.jetpackshowcase.events.domain.models.Event
import com.ceos.jetpackshowcase.events.presentation.screens.events.components.EventItem
import com.ceos.jetpackshowcase.ui.theme.spacings

@Composable
fun EventsScreen(vm: EventsScreenViewModel) {
    EventsScreenContent(vm.eventPagingFlow.collectAsLazyPagingItems())
}

@Composable
private fun EventsScreenContent(
    events: LazyPagingItems<Event>
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = events.loadState) {
        if (events.loadState.refresh is LoadState.Error) {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (events.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(horizontal = MaterialTheme.spacings.smallSpacing),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacings.default),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(
                    count = events.itemCount,
                    key = events.itemKey { it.id }
                ) {
                    events[it]?.let { event ->
                        EventItem(event = event)
                    }
                }
                if (events.loadState.append is LoadState.Loading) {
                    item {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }


}