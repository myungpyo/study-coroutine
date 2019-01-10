package com.smp.coroutineplayground.support

import io.reactivex.disposables.Disposable


fun Disposable.bind(autoDisposable: AutoDisposable) {
    autoDisposable.bind(this)
}