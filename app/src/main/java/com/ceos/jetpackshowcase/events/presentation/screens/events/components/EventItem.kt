package com.ceos.jetpackshowcase.events.presentation.screens.events.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.ceos.jetpack_ui.components.VSpacer
import com.ceos.jetpackshowcase.events.domain.models.Event
import com.ceos.jetpackshowcase.ui.theme.AppTheme
import com.ceos.jetpackshowcase.ui.theme.secondary
import com.ceos.jetpackshowcase.ui.theme.spacings
import com.mohamedrejeb.richeditor.model.rememberRichTextState

@Composable
fun EventItem(
    modifier: Modifier = Modifier,
    event: Event
) {

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = MaterialTheme.spacings.defaultElevation
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacings.default)
        ) {
            Text(text = event.title, style = MaterialTheme.typography.titleLarge)
            HorizontalDivider()
            VSpacer(MaterialTheme.spacings.smallSpacing)
            Text(
                text = event.description.orEmpty().toRichHtmlString(), style = MaterialTheme.typography.bodySmall.secondary,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

}
@Composable
fun String.toRichHtmlString(): AnnotatedString {
    val state = rememberRichTextState()

    LaunchedEffect(this) {
        state.setHtml(this@toRichHtmlString)
    }

    return state.annotatedString
}

@Preview
@Composable
fun EventItemPreview() {
    AppTheme {
        EventItem(
            event = Event(
                id = "05261346-d982-42d9-b0de-5895549888df",
                title = "Event 1",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            )
        )
    }
}