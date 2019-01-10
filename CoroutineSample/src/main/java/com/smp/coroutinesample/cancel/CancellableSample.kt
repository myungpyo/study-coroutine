package com.smp.coroutinesample.cancel

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(args: Array<String>) = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }

    delay(1300L)
    println("main : I'm tired of waiting!")
    job.cancel()
    job.join()
    //job.cancelAndJoin() extension function is supported.
    println("main : Now I can quit.")
}