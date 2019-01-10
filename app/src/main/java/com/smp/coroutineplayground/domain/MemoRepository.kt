package com.smp.coroutineplayground.domain

import com.smp.coroutineplayground.entity.Memo
import io.reactivex.Single


interface MemoRepository {

    fun getMemoList(): Single<List<Memo>>

    fun getMemo(id: Int): Single<Memo>
}