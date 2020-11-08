package com.smp.coroutinesample.timeout

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout


fun main() = runBlocking<Unit> {
    withTimeout(1300L) {
        launch {
            try {
                repeat(1000) { i ->
                    println("I'm sleeping $i ...")
                    delay(500L)
                }
            } finally {
                println("main : I'm running finally!")
            }
        }
    }
}