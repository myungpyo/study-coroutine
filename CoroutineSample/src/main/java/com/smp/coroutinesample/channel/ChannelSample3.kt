package com.smp.coroutinesample.channel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking<Unit> {
    val numbers = produceNumbers(5)
    val doubledNumbers = produceDouble(numbers)
    doubledNumbers.consumeEach { println(it) }
    println("Done")
}

fun CoroutineScope.produceNumbers(max: Int): ReceiveChannel<Int> = produce {
    for (x in 1..max) {
        send(x)
    }
}

fun CoroutineScope.produceDouble(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {
    numbers.consumeEach { send(it * 2) }
}