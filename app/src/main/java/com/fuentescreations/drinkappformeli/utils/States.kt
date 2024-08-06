package com.fuentescreations.drinkappformeli.utils

import java.lang.Exception

sealed class SimpleStates<out T> {
    class Loading<out T>: SimpleStates<T>()

    class Success<out T>: SimpleStates<T>()

    data class Failure(val e:Exception): SimpleStates<Nothing>()
}