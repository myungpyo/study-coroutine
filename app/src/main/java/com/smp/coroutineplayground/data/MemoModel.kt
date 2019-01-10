package com.smp.coroutineplayground.data


data class MemoModel constructor(
    val id: Int,
    val title: String,
    val content: String,
    val lastModifiedAt: Long,
    val createdAt: Long
)