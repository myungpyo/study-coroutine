package com.smp.coroutineplayground.domain

import com.smp.coroutineplayground.entity.Memo
import io.reactivex.Single


class GetMemoListUseCase constructor(private val repository: MemoRepository) :
    SingleUseCase<List<Memo>> {

    override fun execute(): Single<List<Memo>> {
        return repository.getMemoList()
    }

}