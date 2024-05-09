package com.ceos.jetpackshowcase.error_handling


sealed class Outcome<out R, out E : Outcome.Error> {
    data class Success<R>(val value: R) : Outcome<R, Nothing>()
    data class Failure<E : Error>(val error: E) : Outcome<Nothing, E>()

    fun isSuccessful() = this is Success

    inline fun <RO, EO : Error> map(execute: (Outcome<R, E>) -> Outcome<RO, EO>): Outcome<RO, EO> {
        return execute(this)
    }

    inline fun <RO> mapSuccess(execute: (R) -> RO): Outcome<RO, E> {
        return when (this) {
            is Success -> Success(execute(this.value))
            is Failure -> this
        }
    }

    inline fun <EO : Error> mapFailure(execute: (E) -> EO): Outcome<R, EO> {
        return when (this) {
            is Success -> this
            is Failure -> Failure(execute(this.error))
        }
    }

    val valueOrNull: R?
        get() {
            return when (this) {
                is Failure -> null
                is Success -> value
            }
        }

    companion object {
        fun <T> of(content: T) = Success(content)

        fun <E : Error> of(error: E) = Failure(error)
    }

    interface Error
}
