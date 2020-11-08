package com.smp.coroutinesample.concurrency

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

val counterContext = newSingleThreadContext("CounterContext")

fun main() = runBlocking {

    GlobalScope.massiveRun {
        withContext(counterContext) {
            counter++
        }

    }
    println("Counter = $counter")
}
