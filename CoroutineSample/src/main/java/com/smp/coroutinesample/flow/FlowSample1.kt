package com.smp.coroutinesample.flow

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    val testFlow = flow {
        emit(1)
        emit(2)
        emit(3)
    }

    testFlow.collect {value ->
        println(value)
    }
}

