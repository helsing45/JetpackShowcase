package com.ceos.jetpackshowcase.authentification.presentation.screens.login

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.ceos.jetpackshowcase.MainActivity
import com.ceos.jetpackshowcase.core.navigation.Navigator
import com.ceos.jetpackshowcase.core.navigation.Routes
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@HiltAndroidTest
class LoginScreenKtTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var navigator: Navigator

    @Before
    fun setUp() {
        hiltRule.inject()

        composeRule.runOnUiThread {
            navigator.navigateTo(Routes.LOGIN_SCREEN)
        }
    }

    @Test
    fun whenFirstLaunched_loginButtonIsDisabled() = runBlocking<Unit>{
        composeRule.onNodeWithTag("login_button")
            .assertIsDisplayed()
            .assertIsNotEnabled()

    }

    @Test
    fun whenFormIsValid_loginButtonIsEnabled() {
        composeRule.onNodeWithTag("email_input").performTextInput("email@gmail.com")
        composeRule.onNodeWithTag("password_input").performTextInput("password")
        composeRule.onNodeWithTag("login_button").assertIsEnabled()
    }

    @Test
    fun whenEmailIsNotValid_loginButtonIsDisabled() {
        composeRule.onNodeWithTag("email_input").performTextInput("email")
        composeRule.onNodeWithTag("password_input").performTextInput("password")
        composeRule.onNodeWithTag("login_button").assertIsNotEnabled()
    }


    @Test
    fun whenPasswordTooShort_loginButtonIsDisabled() {
        composeRule.onNodeWithTag("email_input").performTextInput("email@gmail.com")
        composeRule.onNodeWithTag("password_input").performTextInput("pa")
        composeRule.onNodeWithTag("login_button").assertIsNotEnabled()
    }

    @Test
    fun whenCredentialAreValid_navigateToHome() =runBlocking<Unit>{
        composeRule.onNodeWithTag("email_input").performTextInput("test@gmail.com")
        composeRule.onNodeWithTag("password_input").performTextInput("password")
        composeRule.onNodeWithTag("login_button").assertIsEnabled().performClick()
        composeRule.onNodeWithTag("BottomNavigationBar").assertIsDisplayed()
    }

    @Test
    fun whenCredentialAreNotValid_displayError() =runBlocking<Unit>{
        composeRule.onNodeWithTag("email_input").performTextInput("admin@gmail.com")
        composeRule.onNodeWithTag("password_input").performTextInput("password")
        composeRule.onNodeWithTag("login_button").assertIsEnabled().performClick()

        composeRule.onNodeWithTag("error_text").assertTextEquals("Bad credentials")
    }
}