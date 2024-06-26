package com.ceos.jetpackshowcase.core.logger

enum class LogPriority(val value: Int) {
    VERBOSE(2),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6);

    companion object {
        fun byValue(value: Int) = entries.firstOrNull { it.value == value }
    }
}
