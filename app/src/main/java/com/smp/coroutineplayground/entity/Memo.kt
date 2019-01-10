package com.smp.coroutineplayground.entity


data class Memo constructor(
    val id: Int,
    val title: String,
    val content: String,
    val lastModifiedAt: Long,
    val createdAt: Long
)