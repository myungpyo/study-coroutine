package com.smp.coroutinesample.concurrency

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    CoroutineScope(counterContext).massiveRun {
        counter++

    }
    println("Counter = $counter")
}
