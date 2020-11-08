package com.smp.coroutinesample.channel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking<Unit> {
    val producer = produceNumbers()
    repeat(5) {
        val job = launchProcessor(it, producer)
        if (it == 3) {
            delay( 200)
            job.cancel()
        }
    }
    delay(950L)
    producer.cancel()
}

fun CoroutineScope.produceNumbers() = produce<Int> {
    var x = 1
    while (true) {
        send(x++)
        delay(100L)
    }
}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {

//    for (msg in channel) {
//        println("Processor #$id received $msg")
//    }

    channel.consumeEach {
        println("Processor #$id received $it")
    }
}