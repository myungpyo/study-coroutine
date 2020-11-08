package com.smp.coroutinesample.cancel

import kotlinx.coroutines.*


fun main() = runBlocking {
    val job = launch(Dispatchers.Default) {
        for (i in 1..10) {
            println("I'm sleeping $i ...")
            Thread.sleep(500L)
        }
    }

    delay(1300L)
    println("main : I'm tired of waiting!")
    job.cancelAndJoin()
    println("main : Now I can quit.")
}