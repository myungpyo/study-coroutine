package com.smp.coroutinesample.timeout

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking<Unit> {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            println("main : I'm running finally!")
        }
    }

    launch {
        delay(1300L)
        println("main : I'm tired of waiting. Cancel the job!")
        if (job.isActive) {
            job.cancelAndJoin()
        }
    }
}