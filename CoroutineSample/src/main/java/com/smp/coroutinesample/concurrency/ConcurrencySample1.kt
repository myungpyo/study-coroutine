package com.smp.coroutinesample.concurrency

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//@Volatile // in Kotlin `volatile` is an annotation
var counter = 0
val mtContext = newFixedThreadPoolContext(2, "mtPool")

fun main() = runBlocking {

    GlobalScope.massiveRun {
//    CoroutineScope(mtContext).massiveRun {
        counter++
    }
    println("Counter = $counter")
}

suspend fun CoroutineScope.massiveRun(action: suspend () -> Unit) {
    val n = 100  // number of coroutines to launch
    val k = 1000 // times an action is repeated by each coroutine
    val time = measureTimeMillis {
        val jobs = List(n) {
            launch {
                repeat(k) { action() }
            }
        }
        jobs.forEach { it.join() }
    }
    println("Completed ${n * k} actions in $time ms")
}