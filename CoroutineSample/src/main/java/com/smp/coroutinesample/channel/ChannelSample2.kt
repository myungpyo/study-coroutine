package com.smp.coroutinesample.channel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking<Unit> {
    val squares = produceSquares(5)
    squares.consumeEach { println(it) }
    println("Done")
}

fun CoroutineScope.produceSquares(max: Int): ReceiveChannel<Int> = produce {
    for (x in 1..max) {
        send(x * x)
    }
}