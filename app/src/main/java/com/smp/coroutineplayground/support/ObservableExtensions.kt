package com.smp.coroutineplayground.support

import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable

fun <T> Observable<T>.syncProgress(
    progressState: MutableLiveData<Progress>,
    startsWith: Progress = Progress.INITIAL
): Observable<T> {
    return doOnSubscribe { progressState.postValue(startsWith) }
        .doFinally { progressState.postValue(Progress.IDLE) }
}