package com.smp.coroutinesample.exception

import kotlinx.coroutines.*


fun main(args: Array<String>) = runBlocking<Unit> {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception")
    }
    val job = GlobalScope.launch(handler) {
        throw AssertionError()
    }
    val deferred = GlobalScope.async(handler) {
        throw ArithmeticException() // Nothing will be printed, relying on user to call deferred.await()
    }

    joinAll(job, deferred)
}

