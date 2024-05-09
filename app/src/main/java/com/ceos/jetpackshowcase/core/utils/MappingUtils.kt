package com.ceos.jetpackshowcase.core.utils

import com.ceos.jetpackshowcase.error_handling.UnexpectedNullWhileMappingError

fun <T> mapFieldOrThrow(field: T?, name: String): T = field ?: throw UnexpectedNullWhileMappingError("$name is null")