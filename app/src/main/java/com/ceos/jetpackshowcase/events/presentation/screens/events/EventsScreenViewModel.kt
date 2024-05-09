package com.ceos.jetpackshowcase.events.presentation.screens.events

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.map
import com.ceos.jetpackshowcase.events.data.local.entities.EventEntity
import com.ceos.jetpackshowcase.events.data.mappers.toDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class EventsScreenViewModel @Inject constructor(
    private val pager: Pager<Int, EventEntity>
) : ViewModel() {
    val eventPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toDomain() }
        }
}