package com.smp.coroutineplayground.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smp.coroutineplayground.R
import com.smp.coroutineplayground.databinding.MemoItemBinding
import com.smp.coroutineplayground.entity.Memo
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.memo_item.*
import java.text.DateFormat
import java.util.*


class MemosAdapter : RecyclerView.Adapter<MemoViewHolder>() {

    private val memos = mutableListOf<Memo>()

    fun submit(memos: List<Memo>) {
        this.memos.clear()
        this.memos.addAll(memos)
    }

    override fun getItemCount(): Int {
        return memos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        return MemoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.bind(memos[position])
    }

}

class MemoViewHolder(
    private val binding: MemoItemBinding,
    private val dateFormat: DateFormat = DateFormat.getDateInstance()
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): MemoViewHolder {
            val binding = MemoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MemoViewHolder(binding)
        }
    }

    fun bind(memo: Memo) {
        binding.titleView.text = memo.title
        binding.contentView.text = memo.content
        binding.timeView.text = dateFormat.format(Date(memo.lastModifiedAt))
    }

}