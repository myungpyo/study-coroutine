package com.smp.coroutineplayground.support

import io.reactivex.disposables.Disposable


interface AutoDisposable {
    fun bind(disposable: Disposable)
}