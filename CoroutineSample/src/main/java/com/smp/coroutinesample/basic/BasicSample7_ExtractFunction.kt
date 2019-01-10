package com.smp.coroutinesample.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(args: Array<String>) = runBlocking {
    launch {
        doWorld()
    }
    println("Hello,")
}

suspend fun doWorld() {
    delay(1000L)
    println("World!")
}