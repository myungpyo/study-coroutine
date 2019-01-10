package com.smp.coroutinesample.context

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking<Unit> {
    println("My job is ${coroutineContext[Job]}")
}

