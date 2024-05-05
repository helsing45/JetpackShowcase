package com.ceos.jetpack_ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ceos.jetpack_ui.R
import com.ceos.jetpack_ui.components.PrimaryButton
import com.ceos.jetpack_ui.components.SecondaryButton
import com.ceos.jetpack_ui.components.TextButton

@Composable
fun ButtonsDemoScreen() {
    val buttonModifier = Modifier.width(350.dp)
    Column(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.surface), horizontalAlignment = Alignment.CenterHorizontally) {
        PrimaryButton(
            modifier = buttonModifier,
            text = stringResource(id = R.string.primary_button)
        ) {}
        PrimaryButton(
            modifier = buttonModifier,
            text = stringResource(id = R.string.disabled_primary),
            enabled = false
        ) {}
        PrimaryButton(
            modifier = buttonModifier,
            text = stringResource(id = R.string.primary_with_icon),
            icon = Icons.Outlined.Check
        ) {}
        PrimaryButton(
            modifier = buttonModifier,
            text = stringResource(id = R.string.disabled_primary_with_icon),
            enabled = false,
            icon = Icons.Outlined.Check
        ) {}

        SecondaryButton(
            modifier = buttonModifier,
            text = stringResource(id = R.string.secondary_button)
        ) {}
        SecondaryButton(
            modifier = buttonModifier,
            text = stringResource(id = R.string.disabled_secondary),
            enabled = false
        ) {}
        SecondaryButton(
            modifier = buttonModifier,
            text = stringResource(id = R.string.secondary_with_icon),
            icon = Icons.Outlined.Check
        ) {}
        SecondaryButton(
            modifier = buttonModifier,
            text = stringResource(id = R.string.disabled_secondary_with_icon),
            enabled = false,
            icon = Icons.Outlined.Check
        ) {}

        TextButton(
            modifier = buttonModifier,
            text = stringResource(id = R.string.text_button)
        ) {}
        TextButton(
            modifier = buttonModifier,
            text = stringResource(id = R.string.disabled_text_button),
            enabled = false
        ) {}
        TextButton(
            modifier = buttonModifier,
            text = stringResource(id = R.string.text_button_with_icon),
            icon = Icons.Outlined.Check
        ) {}
        TextButton(
            modifier = buttonModifier,
            text = stringResource(id = R.string.disabled_text_button_with_icon),
            enabled = false,
            icon = Icons.Outlined.Check
        ) {}

    }

}