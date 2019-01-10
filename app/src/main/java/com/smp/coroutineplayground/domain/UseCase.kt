package com.smp.coroutineplayground.domain

import io.reactivex.Observable
import io.reactivex.Single


interface UseCase<Result> {
    fun execute(): Result
}

interface UseCaseWithParam<Params, Result> : UseCase<Result> {

    override fun execute(): Result {
        throw UnsupportedOperationException("You must use parameterized version for this use case")
    }

    fun execute(params: Params): Result
}

interface ObservableUseCase<Result> : UseCase<Observable<Result>>

interface ObservableUseCaseWithParam<Params, Result> : UseCaseWithParam<Params, Observable<Result>>

interface SingleUseCase<Result> : UseCase<Single<Result>>

interface SingleUseCaseWithParam<Params, Result> : UseCaseWithParam<Params, Single<Result>>