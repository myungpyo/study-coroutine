package com.smp.coroutineplayground.support


interface Mapper<From, To> {
    fun map(obj: From): To
    fun mapAll(objs: Iterable<From>): List<To>
    fun reverse(obj: To): From
    fun reverseAll(objs: Iterable<To>): List<From>
}