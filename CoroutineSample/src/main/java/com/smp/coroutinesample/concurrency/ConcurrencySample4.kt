package com.smp.coroutinesample.concurrency

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {

    CoroutineScope(counterContext).massiveRun {
        counter++

    }
    println("Counter = $counter")
}
