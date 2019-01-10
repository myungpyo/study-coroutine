package com.smp.coroutineplayground.presentation

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smp.coroutineplayground.R
import com.smp.coroutineplayground.entity.Memo
import com.smp.coroutineplayground.support.BaseActivity
import com.smp.coroutineplayground.support.Progress
import com.smp.coroutineplayground.support.observeNotNull
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipeRefreshView.setOnRefreshListener {
            mainViewModel.syncMemos()
        }

        memosView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = MemosAdapter()
        }

        withViewModel<MainViewModel> {
            observeNotNull(memos) {
                submitList(it)
            }

            observeNotNull(memosSyncProgress) {
                swipeRefreshView.isRefreshing = it != Progress.IDLE
            }
        }


        mainViewModel.syncMemos()
    }

    private fun submitList(memos: List<Memo>) {
        (memosView.adapter as? MemosAdapter)?.let {
            it.submit(memos)
            it.notifyDataSetChanged()
        }
    }
}
