package com.smp.coroutineplayground.data

import com.smp.coroutineplayground.support.Mapper
import com.smp.coroutineplayground.entity.Memo


object MemoEntityMapper : Mapper<MemoModel, Memo> {

    override fun map(obj: MemoModel): Memo {
        return Memo(
            obj.id,
            obj.title,
            obj.content,
            obj.lastModifiedAt,
            obj.createdAt
        )
    }

    override fun mapAll(objs: Iterable<MemoModel>): List<Memo> {
        return objs.map { map(it) }
    }

    override fun reverse(obj: Memo): MemoModel {
        return MemoModel(
            obj.id,
            obj.title,
            obj.content,
            obj.lastModifiedAt,
            obj.createdAt
        )
    }

    override fun reverseAll(objs: Iterable<Memo>): List<MemoModel> {
        return objs.map { reverse(it) }
    }

}