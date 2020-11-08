package com.smp.coroutinesample.context

import kotlinx.coroutines.*


val threadLocal = ThreadLocal<String?>()

fun main() = runBlocking<Unit> {

    threadLocal.set("main")
    println("Pre-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
    val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "launch")) {
        println("Launch start, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
        yield()
        println("After yield, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")

        withContext(threadLocal.asContextElement(value = "child")) {
            println("Child : Launch start, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
            yield()
            println("Child : After yield, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
        }
    }
    job.join()
    println("Post-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
}