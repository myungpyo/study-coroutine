package com.smp.coroutineplayground.presentation

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smp.coroutineplayground.R
import com.smp.coroutineplayground.databinding.MainActivityBinding
import com.smp.coroutineplayground.entity.Memo
import com.smp.coroutineplayground.support.BaseActivity
import com.smp.coroutineplayground.support.Progress
import com.smp.coroutineplayground.support.observeNotNull
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private lateinit var binding: MainActivityBinding

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.swipeRefreshView.setOnRefreshListener {
            mainViewModel.syncMemos()
        }

        binding.memosView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = MemosAdapter()
        }

        withViewModel<MainViewModel> {
            observeNotNull(memos) {
                submitList(it)
            }

            observeNotNull(memosSyncProgress) {
                binding.swipeRefreshView.isRefreshing = it != Progress.IDLE
            }
        }


        mainViewModel.syncMemos()
    }

    private fun submitList(memos: List<Memo>) {
        (binding.memosView.adapter as? MemosAdapter)?.let {
            it.submit(memos)
            it.notifyDataSetChanged()
        }
    }
}
