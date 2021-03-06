package com.smp.coroutineplayground.data

import android.util.Log
import java.util.*


class MemoDataSourceImpl : MemoDataSource {

    companion object {
        const val MAX_MOCK_MEMO = 100
    }

    val mockMemos: List<MemoModel> by lazy {
        val cal = Calendar.getInstance()

        1.rangeTo(MAX_MOCK_MEMO).map {
            MemoModel(
                it,
                "Test Memo $it",
                "This is test memo $it",
                cal.apply { add(Calendar.DAY_OF_YEAR, -1) }.timeInMillis,
                cal.apply { add(Calendar.DAY_OF_YEAR, -1) }.timeInMillis
            )
        }
    }


    override fun getMemoList(): List<MemoModel> {
        try {
            Thread.sleep(2000)
            return mockMemos.toList()
        } catch (throwable: Throwable) {
            Log.e("MemoDataSource", "getMemoList Error : $throwable")
        }
        return listOf()
    }

    override fun getMemo(id: Int): MemoModel? {
        if (id <= 0 || id > MAX_MOCK_MEMO) {
            return null
        }

        try {
            Thread.sleep(1000)
            return mockMemos[id - 1]
        } catch (throwable: Throwable) {
            Log.e("MemoDataSource", "getMemo Error : $throwable")
        }
        return null
    }

}