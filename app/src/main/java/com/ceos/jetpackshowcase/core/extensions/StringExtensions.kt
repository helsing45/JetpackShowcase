package com.ceos.jetpackshowcase.core.extensions

fun String?.nullIfEmpty() = this?.ifEmpty { null }