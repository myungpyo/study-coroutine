package com.smp.coroutinesample.channel

import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

data class Ball(var hits: Int)

fun main() = runBlocking<Unit> {
    val table = Channel<Ball>()

    launch { player("ping", table) }
    launch { player("pong", table) }

    table.send(Ball(0))
    delay(1000)
    coroutineContext.cancelChildren()
}

suspend fun player(name: String, table: Channel<Ball>) {
    for (ball in table) {
        ball.hits++
        println("$name $ball")
        // Comment out below delay to see the fairness a bit more.
        delay(300)
        table.send(ball)
    }
}