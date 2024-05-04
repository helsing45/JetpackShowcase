package com.ceos.jetpackshowcase.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val extraSmallSpacing: Dp = 4.dp,
    val smallSpacing: Dp = 8.dp,
    val smallMedianSpacing: Dp = 12.dp,
    val default: Dp = 16.dp,
    val mediumMedianSpacing: Dp = 20.dp,
    val mediumSpacing: Dp = 24.dp,
    val largeMedianSpacing: Dp = 28.dp,
    val largeSpacing: Dp = 32.dp,
    val extraLargeMedianSpacing: Dp = 36.dp,
    val extraLargeSpacing: Dp = 40.dp,
    val smallSize: Dp = 48.dp,
    val smallMedianSize: Dp = 52.dp,
    val mediumSize: Dp = 56.dp,
    val mediumMedianSize: Dp = 60.dp,
    val largeSize: Dp = 64.dp,
    val largeMedianSize: Dp = 68.dp,
    val extraLargeSize: Dp = 72.dp,
    val extraLargeMedianSize: Dp = 76.dp,
)

val localSpacing = compositionLocalOf { Spacing() }

val MaterialTheme.spacings: Spacing
    @Composable
    @ReadOnlyComposable
    get() = localSpacing.current