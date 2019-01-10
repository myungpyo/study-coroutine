package com.smp.coroutinesample.channel

fun main(args: Array<String>) {
    var cur = getNumberIteratorFrom(2)
    for (i in 1..10) {
        val prime = cur.next()
        println(prime)
        cur = getFilteredNumberIterator(cur, prime)
    }
    println("Done")
}

fun getNumberIteratorFrom(start: Int) = iterator {
    var x = start
    while (true) yield(x++) // infinite stream of integers from start
}

fun getFilteredNumberIterator(numbers: Iterator<Int>, prime: Int) = iterator {
    for (x in numbers) {
        if (x % prime != 0) yield(x)
    }
}