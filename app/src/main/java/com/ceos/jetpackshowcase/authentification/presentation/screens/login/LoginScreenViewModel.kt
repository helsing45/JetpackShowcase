package com.ceos.jetpackshowcase.authentification.presentation.screens.login

import android.util.Patterns.EMAIL_ADDRESS
import androidx.lifecycle.ViewModel
import com.ceos.jetpackshowcase.authentification.domain.AuthenticationError
import com.ceos.jetpackshowcase.authentification.domain.SignInWithEmailAndPasswordUseCase
import com.ceos.jetpackshowcase.core.DispatcherProvider
import com.ceos.jetpackshowcase.core.navigation.Navigator
import com.ceos.jetpackshowcase.core.navigation.Routes
import com.ceos.jetpackshowcase.error_handling.Outcome
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel
@Inject constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val navigator: Navigator,
    private val signInWithEmailAndPasswordUseCase: SignInWithEmailAndPasswordUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<State> = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    fun onPasswordChanged(value: String) {
        onInputChanged(_uiState.value.email, value)
    }

    fun onEmailChanged(value: String) {
        onInputChanged(value, _uiState.value.password)
    }

    fun login() {
        _uiState.update {
            it.copy(isLoading = true)
        }
        val state = _uiState.value
        CoroutineScope(dispatcherProvider.io()).launch {
            signInWithEmailAndPasswordUseCase.signIn(state.email, state.password)
                .collectLatest { outcome ->
                    when(outcome){
                        is Outcome.Success -> navigateToHome()
                        is Outcome.Failure -> {
                            _uiState.update { state ->
                                state.copy(
                                    isLoading = false,
                                    error = outcome.error
                                )
                            }
                        }
                    }
                }
        }
    }

    private fun navigateToHome() {
        CoroutineScope(dispatcherProvider.main()).launch {
        navigator.navigateTo(Routes.MAIN_GRAPH){
            popUpTo(0)
        }
            }
    }

    private fun onInputChanged(email: String, password: String) {
        val isFormCompleted = emailIsValid(email) && passwordIsValid(password)
        _uiState.update {
            it.copy(
                isFormCompleted = isFormCompleted,
                email = email,
                password = password,
            )
        }
    }

    private fun emailIsValid(email: String): Boolean {
        return EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun passwordIsValid(password: String): Boolean {
        return password.length >= 8
    }

    data class State(
        val isFormCompleted: Boolean = false,
        val isLoading: Boolean = false,
        val error: AuthenticationError? = null,
        val email: String = "",
        val password: String = "",
    )
}