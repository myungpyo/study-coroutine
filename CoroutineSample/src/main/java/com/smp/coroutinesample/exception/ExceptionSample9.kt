package com.smp.coroutinesample.exception

import kotlinx.coroutines.*
import java.io.IOException


fun main(args: Array<String>) = runBlocking<Unit> {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception")
    }
    supervisorScope {
        val child = launch(handler) {
            println("Child throws an exception")
            throw AssertionError()
        }
        println("Scope is completing")
    }
    println("Scope is completed")
}

