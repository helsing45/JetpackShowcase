package com.ceos.jetpackshowcase.ui.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ceos.jetpackshowcase.R
import com.ceos.jetpackshowcase.core.navigation.Routes

enum class NavigationItems(
    val route: String,
    @DrawableRes val iconId: Int,
    @DrawableRes val selectedIconId: Int,
    @StringRes val labelResId: Int
) {
    PARKS(
        Routes.PARKS_SCREEN,
        R.drawable.ic_outline_parks,
        R.drawable.ic_filled_parks,
        R.string.bottom_nav_parks_label
    ),
    NEWS(
        Routes.NEWS_SCREEN,
        R.drawable.ic_outline_news,
        R.drawable.ic_filled_news,
        R.string.bottom_nav_news_label
    ),
    PROFILE(
        Routes.PROFILE_SCREEN,
        R.drawable.ic_outline_profile,
        R.drawable.ic_filled_profile,
        R.string.bottom_nav_profile_label
    )

}