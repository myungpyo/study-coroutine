package com.smp.coroutineplayground

import android.app.Application
import com.smp.coroutineplayground.data.MemoDataSource
import com.smp.coroutineplayground.data.MemoDataSourceImpl
import com.smp.coroutineplayground.data.MemoRepositoryImpl
import com.smp.coroutineplayground.domain.GetMemoListUseCase
import com.smp.coroutineplayground.domain.GetMemoUseCase
import com.smp.coroutineplayground.domain.MemoRepository
import com.smp.coroutineplayground.presentation.MainViewModel
import com.smp.coroutineplayground.support.SchedulerProvider
import com.smp.coroutineplayground.support.SchedulerProviderImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val memoModule = module {
            single { SchedulerProviderImpl() as SchedulerProvider }
            single { MemoDataSourceImpl() as MemoDataSource }
            single { MemoRepositoryImpl(get()) as MemoRepository }
            single { GetMemoListUseCase(get()) }
            single { GetMemoUseCase(get()) }
            viewModel { MainViewModel(get(), get()) }
        }

        startKoin {
            modules(memoModule)
        }
    }
}