package com.smp.coroutineplayground.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.smp.coroutineplayground.domain.GetMemoListUseCase
import com.smp.coroutineplayground.entity.Memo
import com.smp.coroutineplayground.support.*


class MainViewModel(
    private val schedulerProvider: SchedulerProvider,
    private val getMemoListUseCase: GetMemoListUseCase
) : BaseViewModel() {

    private val _memos = MutableLiveData<List<Memo>>()
    val memos: LiveData<List<Memo>> = _memos
    val memosSyncProgress = MediatorLiveData<Progress>()

    fun syncMemos() {
        getMemoListUseCase.execute()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .syncProgress(memosSyncProgress)
            .subscribe { result ->
                _memos.value = result
            }
            .bind(this)
    }

}