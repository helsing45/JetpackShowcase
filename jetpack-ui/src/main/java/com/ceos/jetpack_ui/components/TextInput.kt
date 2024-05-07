package com.ceos.jetpack_ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ceos.jetpack_ui.R
import com.ceos.jetpack_ui.R.drawable.ic_visibility
import com.ceos.jetpack_ui.R.drawable.ic_visibility_off


@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String? = null,
    leadingIcon: ImageVector? = null,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    var passwordVisible by remember { mutableStateOf(false) }
    TextInput(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        leadingIcon = leadingIcon,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        placeholder = placeholder,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        isError = isError,
        singleLine = true,
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    painter = painterResource(id = if (passwordVisible) ic_visibility else ic_visibility_off),
                    stringResource(id = if (passwordVisible) R.string.a11y_hide_password else R.string.a11y_show_password)
                )
            }
        }
    )


}

@Composable
fun TextInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String? = null,
    leadingIcon: ImageVector? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
) {
    val leadingIconComponent = leadingIcon?.let<ImageVector, @Composable (() -> Unit)> {
        @Composable {
            Icon(
                imageVector = it,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    }

    val placeholderComponent = placeholder?.let<String, @Composable (() -> Unit)> {
        @Composable {
            Text(
                it,
                style = MaterialTheme.typography.labelLarge.copy(color = MaterialTheme.colorScheme.secondary)
            )
        }
    }

    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .border(
                0.5.dp,
                shape = RoundedCornerShape(4.dp),
                color = if (isError) MaterialTheme.colorScheme.error else
                    MaterialTheme.colorScheme.primary
            )
            .fillMaxWidth(),
        leadingIcon = leadingIconComponent,
        textStyle = MaterialTheme.typography.bodyLarge,
        visualTransformation = visualTransformation,
        placeholder = placeholderComponent,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        trailingIcon = trailingIcon,
        maxLines = maxLines,
        singleLine = singleLine
    )
}

