package com.ceos.jetpackshowcase.authentification.presentation.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceos.jetpack_ui.components.PasswordInput
import com.ceos.jetpack_ui.components.PrimaryButton
import com.ceos.jetpack_ui.components.TextButton
import com.ceos.jetpack_ui.components.TextInput
import com.ceos.jetpack_ui.components.VSpacer
import com.ceos.jetpackshowcase.R
import com.ceos.jetpackshowcase.authentification.domain.AuthenticationError
import com.ceos.jetpackshowcase.ui.theme.error
import com.ceos.jetpackshowcase.ui.theme.secondary
import com.ceos.jetpackshowcase.ui.theme.spacings


@Composable
fun LoginScreen(
    vm: LoginScreenViewModel
) {
    val state by vm.uiState.collectAsState()
    LoginContentScreen(
        isFormCompleted = state.isFormCompleted,
        isLoading = state.isLoading,
        error = state.error.toDisplay(),
        email = state.email,
        onEmailChanged = vm::onEmailChanged,
        password = state.password,
        onPasswordChanged = vm::onPasswordChanged,
        onLoginClicked = vm::login,
    )
}

@Composable
private fun AuthenticationError?.toDisplay(): String? {
    return when (this) {
        AuthenticationError.InvalidCredential -> stringResource(id = R.string.login_error_invalid_credential)
        AuthenticationError.UnknownError -> stringResource(id = R.string.unkown_error)
        null -> null
    }
}

@Composable
private fun LoginContentScreen(
    isFormCompleted: Boolean,
    isLoading: Boolean,
    error: String?,
    email: String,
    onEmailChanged: (String) -> Unit = {},
    password: String,
    onPasswordChanged: (String) -> Unit = {},
    onPasswordForgetClicked: () -> Unit = {},
    onLoginClicked: () -> Unit = {}
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val onSubmitCredential = {
        focusManager.clearFocus()
        onLoginClicked.invoke()
    }
    Scaffold(
        content = { paddingValues ->
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = MaterialTheme.spacings.default)

            )
            {
                item {
                    VSpacer(60.dp)
                    Text(
                        stringResource(id = R.string.welcome_back_label),
                        style = MaterialTheme.typography.headlineMedium
                    )
                    VSpacer( MaterialTheme.spacings.smallSpacing)
                    Text(
                        stringResource(id = R.string.welcome_back_subtitle),
                        style = MaterialTheme.typography.bodyMedium.secondary
                    )
                    VSpacer(MaterialTheme.spacings.mediumSpacing)
                    TextInput(
                        value = email,
                        onValueChange = onEmailChanged,
                        modifier = Modifier
                            .testTag("email_input")
                            .focusRequester(focusRequester),
                        maxLines = 1,
                        isError = error != null,
                        leadingIcon = Icons.Filled.Email,
                        placeholder = stringResource(id = R.string.enter_email_placeholder),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                    )
                    VSpacer(MaterialTheme.spacings.default)
                    PasswordInput(
                        value = password,
                        onValueChange = onPasswordChanged,
                        isError = error != null,
                        modifier = Modifier.testTag("password_input"),
                        leadingIcon = Icons.Filled.Lock,
                        placeholder = stringResource(id = R.string.password_placeholder),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = {
                            onSubmitCredential.invoke()
                        }
                        )
                    )
                    VSpacer(MaterialTheme.spacings.smallSpacing)
                    Text(
                        modifier = Modifier.fillMaxWidth().testTag("error_text") ,
                        textAlign = TextAlign.End,
                        text = error.orEmpty(),
                        style = MaterialTheme.typography.labelLarge.error
                    )
                    VSpacer(MaterialTheme.spacings.default)
                    TextButton(
                        text = stringResource(id = R.string.forgot_password_label),
                        onClick = onPasswordForgetClicked
                    )
                    VSpacer(MaterialTheme.spacings.smallSpacing)
                    PrimaryButton(
                        modifier = Modifier.testTag("login_button"),
                        isLoading = isLoading,
                        text = stringResource(id = R.string.sign_in_button_text),
                        enabled = isFormCompleted,
                        onClick = onSubmitCredential
                    )
                    VSpacer(MaterialTheme.spacings.default)
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Gray,
                                    fontSize = 14.sp
                                )
                            ) {
                                append(stringResource(id = R.string.no_account))
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    fontSize = 14.sp
                                )
                            )
                            {
                                append(stringResource(id = R.string.register_here))
                            }
                        }
                    )
                    VSpacer(MaterialTheme.spacings.default)
                }
            }
            LaunchedEffect(key1 = true) {
                focusRequester.requestFocus()
            }

        }
    )
}