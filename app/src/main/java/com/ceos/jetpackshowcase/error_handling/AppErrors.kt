package com.ceos.jetpackshowcase.error_handling

data class UnexpectedNullWhileMappingError(override val message: String) : Exception(message)