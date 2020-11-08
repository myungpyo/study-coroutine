package com.smp.coroutinesample.concurrency

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

var atomicCounter = AtomicInteger()

fun main() = runBlocking {

    GlobalScope.massiveRun {
//    CoroutineScope(mtContext).massiveRun {
        atomicCounter.incrementAndGet()
    }
    println("Counter = ${atomicCounter.get()}")
}
