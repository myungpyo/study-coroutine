package com.smp.coroutinesample.context

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking<Unit> {

    launch(Dispatchers.Default + CoroutineName("test")) {
        println("I'm working in thread ${Thread.currentThread().name}")
    }
}

