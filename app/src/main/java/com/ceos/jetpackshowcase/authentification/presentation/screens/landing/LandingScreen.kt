package com.ceos.jetpackshowcase.authentification.presentation.screens.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ceos.jetpack_ui.components.HSpacer
import com.ceos.jetpack_ui.components.PrimaryButton
import com.ceos.jetpack_ui.components.SecondaryButton
import com.ceos.jetpackshowcase.R
import com.ceos.jetpackshowcase.ui.theme.AppTheme
import com.ceos.jetpackshowcase.ui.theme.spacings

@Composable
fun LandingScreen(onLoginClicked: () -> Unit = {},
                  onSignUpClicked:() -> Unit = {}) {
    Scaffold(
        content = {
            Box(
                modifier = Modifier.padding(it),
                content = {
                    Image(
                        alpha = 0.9F,
                        painter = painterResource(id = R.drawable.landing_screen_bg),
                        modifier = Modifier.fillMaxHeight(),
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds,
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.4F))
                    )
                    Column(
                        verticalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .padding(MaterialTheme.spacings.mediumSpacing)
                            .fillMaxSize(),
                        content = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                content = {
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        alignment = Alignment.BottomCenter,
                                        modifier = Modifier
                                            .height(350.dp)
                                            .width(350.dp),
                                        contentDescription = ""
                                    )
                                    Text(
                                        stringResource(id = R.string.landing_page_title),
                                        style = MaterialTheme.typography.headlineLarge
                                    )
                                })
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                val buttonModifier = Modifier
                                    .fillMaxWidth(0.75f)
                                    .height(50.dp)
                                PrimaryButton(
                                    modifier = buttonModifier,
                                    text = stringResource(id = R.string.login_button),
                                    onClick = onLoginClicked
                                )
                                HSpacer(MaterialTheme.spacings.mediumSpacing)
                                SecondaryButton(
                                    modifier = buttonModifier,
                                    text = stringResource(id = R.string.sign_up_button),
                                    onClick = onSignUpClicked
                                )
                                HSpacer(height = MaterialTheme.spacings.largeSpacing)
                            }
                        })
                })
        })
}

@Preview
@Composable
private fun Preview_LandingScreen_darkTheme(){
    AppTheme(darkTheme = true) {
        LandingScreen()
    }
}

@Preview
@Composable
private fun Preview_LandingScreen_lightTheme(){
    AppTheme(darkTheme = false) {
        LandingScreen()
    }
}