package yuresko.diffutilkotlincleanproject.adapter

import androidx.recyclerview.widget.DiffUtil
import yuresko.diffutilkotlincleanproject.MyDataClass

class DiffUtilCallback(
    private var oldList: List<MyDataClass>,
    private var newList: List<MyDataClass>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}