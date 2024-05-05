package com.ceos.jetpack_ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    icon: ImageVector? = null,
    onClick: () -> Unit,
) {

    val textContentColor = if(enabled) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface.copy(0.38f)
    Button(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick
    ) {
        ButtonContent(
            text = text,
            icon = icon,
            textColor = textContentColor
        )
    }
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    icon: ImageVector? = null,
    onClick: () -> Unit,
) {
    val textContentColor = if(enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(0.38f)
    OutlinedButton(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick
    ) {
        ButtonContent(text = text, icon = icon, textColor = textContentColor)
    }
}

@Composable
fun TextButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    icon: ImageVector? = null,
    onClick: () -> Unit,
) {

    val textContentColor = if(enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(0.38f)
    androidx.compose.material3.TextButton(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick
    ) {
        ButtonContent(text = text, icon = icon, textColor =textContentColor)
    }
}

@Composable
private fun ButtonContent(
    icon: ImageVector? = null,
    text: String,
    textColor: Color,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (icon != null) {
            Icon(imageVector = Icons.Outlined.Check, contentDescription = "")
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text,
            style = MaterialTheme.typography.titleLarge,
            color = textColor,
        )
    }
}