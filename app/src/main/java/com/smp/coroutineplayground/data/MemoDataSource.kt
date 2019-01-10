package com.smp.coroutineplayground.data


interface MemoDataSource {

    fun getMemoList(): List<MemoModel>

    fun getMemo(id: Int): MemoModel?
}