package com.smp.coroutinesample.concurrency

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.runBlocking


fun main(args: Array<String>) = runBlocking {
    val counter = counterActor()
    massiveRun {
        counter.send(IncCounter)
    }

    val response = CompletableDeferred<Int>()
    counter.send(GetCounter(response))
    println("Counter = ${response.await()}")
    counter.close()
    return@runBlocking
}


// Message types for counterActor
sealed class CounterMsg

object IncCounter : CounterMsg() // one-way message to increment counter

class GetCounter(val response: CompletableDeferred<Int>) : CounterMsg() // a request with reply

@ObsoleteCoroutinesApi
fun CoroutineScope.counterActor() = actor<CounterMsg> {
    var counter = 0
    for (msg in channel) {
        when (msg) {
            is IncCounter -> counter++
            is GetCounter -> msg.response.complete(counter)
        }
    }
}