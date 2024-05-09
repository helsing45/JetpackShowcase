package com.ceos.jetpackshowcase.core.logger

interface Logger {
    fun v(message: String?)
    fun v(throwable: Throwable?, message: String? = null)

    fun d(message: String?)
    fun d(throwable: Throwable?, message: String? = null)

    fun i(message: String?)
    fun i(throwable: Throwable?, message: String? = null)

    fun w(message: String?)
    fun w(throwable: Throwable?, message: String? = null)

    fun e(message: String?)
    fun e(throwable: Throwable?, message: String? = null)

    fun log(priority: LogPriority, tag: String? = null, message: String? = null, throwable: Throwable? = null)
}
