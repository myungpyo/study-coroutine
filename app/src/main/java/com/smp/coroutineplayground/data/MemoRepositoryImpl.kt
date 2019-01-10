package com.smp.coroutineplayground.data

import com.smp.coroutineplayground.domain.MemoRepository
import com.smp.coroutineplayground.entity.Memo
import io.reactivex.Single


class MemoRepositoryImpl(private val memoDataSource: MemoDataSource) : MemoRepository {

    override fun getMemoList(): Single<List<Memo>> {
        return Single.defer {
            Single.just(memoDataSource.getMemoList())
                .map { MemoEntityMapper.mapAll(it) }
        }
    }

    override fun getMemo(id: Int): Single<Memo> {
        return Single.defer {
            memoDataSource.getMemo(id)?.let {
                Single.just(it).map { memoModel -> MemoEntityMapper.map(memoModel) }
            } ?: Single.error(IllegalArgumentException("There is no memo with id $id"))
        }
    }

}