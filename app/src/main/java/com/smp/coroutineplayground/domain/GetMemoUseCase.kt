package com.smp.coroutineplayground.domain

import com.smp.coroutineplayground.entity.Memo
import io.reactivex.Single


class GetMemoUseCase constructor(private val repository: MemoRepository) :
    SingleUseCaseWithParam<GetMemoUseCase.Params, Memo> {

    override fun execute(params: Params): Single<Memo> {
        return repository.getMemo(params.id)
    }

    data class Params(val id: Int)
}