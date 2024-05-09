package com.ceos.jetpackshowcase.core.logger

import android.util.Log
import com.ceos.jetpackshowcase.core.logger.LogPriority.DEBUG
import com.ceos.jetpackshowcase.core.logger.LogPriority.ERROR
import com.ceos.jetpackshowcase.core.logger.LogPriority.INFO
import com.ceos.jetpackshowcase.core.logger.LogPriority.VERBOSE
import com.ceos.jetpackshowcase.core.logger.LogPriority.WARN
import java.util.regex.Pattern

class LoggerImpl(
    private val doOnLog: (priority: Int, tag: String?, message: String?, throwable: Throwable?) -> Unit = { _, _, _, _ -> }
) : Logger {

    private fun getTag(): String {
        return Throwable().stackTrace
            .first {
                !it.className.contains("Logger")
            }
            .let(::createStackElementTag)
    }

    private fun createStackElementTag(element: StackTraceElement): String {
        var tag = element.className.substringAfterLast('.')
        val m = ANONYMOUS_CLASS.matcher(tag)
        if (m.find()) {
            tag = m.replaceAll("")
        }
        // Tag length limit was removed in API 26.
        return if (tag.length <= MAX_TAG_LENGTH) {
            tag
        } else {
            tag.substring(0, MAX_TAG_LENGTH)
        }
    }

    override fun v(message: String?) = log(
        priority = VERBOSE,
        tag = null,
        message = message
    )

    override fun v(throwable: Throwable?, message: String?) = log(
        priority = VERBOSE,
        tag = null,
        message = message,
        throwable = throwable
    )

    override fun d(message: String?) = log(
        priority = DEBUG,
        tag = null,
        message = message
    )

    override fun d(throwable: Throwable?, message: String?) = log(
        priority = DEBUG,
        tag = null,
        message = message,
        throwable = throwable
    )

    override fun i(message: String?) = log(
        priority = INFO,
        tag = null,
        message = message
    )

    override fun i(throwable: Throwable?, message: String?) = log(
        priority = INFO,
        tag = null,
        message = message,
        throwable = throwable
    )

    override fun w(message: String?) = log(
        priority = WARN,
        tag = null,
        message = message
    )

    override fun w(throwable: Throwable?, message: String?) = log(
        priority = WARN,
        tag = null,
        message = message,
        throwable = throwable
    )

    override fun e(message: String?) = log(
        priority = ERROR,
        tag = null,
        message = message
    )

    override fun e(throwable: Throwable?, message: String?) = log(
        priority = ERROR,
        tag = null,
        message = message,
        throwable = throwable
    )

    override fun log(priority: LogPriority, tag: String?, message: String?, throwable: Throwable?) {
        if (message == null)
            return

        when (priority) {
            DEBUG -> Log.d(tag ?: getTag(), message, throwable)
            ERROR -> Log.e(tag ?: getTag(), message, throwable)
            INFO -> Log.i(tag ?: getTag(), message, throwable)
            VERBOSE -> Log.v(tag ?: getTag(), message, throwable)
            WARN -> Log.w(tag ?: getTag(), message, throwable)
        }

        doOnLog(priority.value, tag, message, throwable)
    }

    companion object {
        private const val MAX_TAG_LENGTH = 23
        private val ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$")
    }
}
