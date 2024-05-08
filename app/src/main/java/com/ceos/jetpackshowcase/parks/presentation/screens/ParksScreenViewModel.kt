package com.ceos.jetpackshowcase.parks.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ceos.jetpackshowcase.error_handling.Outcome
import com.ceos.jetpackshowcase.parks.domain.models.Park
import com.ceos.jetpackshowcase.parks.domain.models.ParkError
import com.ceos.jetpackshowcase.parks.domain.use_cases.FetchParksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ParksScreenViewModel @Inject constructor(
    private val fetchParksUseCase: FetchParksUseCase
) :
    ViewModel() {

    private val _parks = MutableStateFlow<List<Park>>(emptyList())
    val parks = _parks.asStateFlow()

    fun getParks() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchParksUseCase.getParks()
                .collectLatest {
                    when (it) {
                        is Outcome.Failure ->
                            handleError(it.error)

                        is Outcome.Success -> updateParks(it.value)
                    }
                }
        }

    }

    private fun updateParks(value: List<Park>) {
        _parks.update {
            it.toMutableList().apply {
                clear()
                addAll(value)
            }
        }
    }

    private fun handleError(error: ParkError) {
        //TODO: Handle Error
    }

}