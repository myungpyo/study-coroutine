package com.smp.coroutinesample.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking<Unit> {
    val channel = Channel<Int>(4)

    val sender = launch {
        repeat(10) {
            print("Try to send $it : ")
            channel.send(it)
            print("Done\n")
        }
    }

    delay(1000)
    sender.cancel()
}