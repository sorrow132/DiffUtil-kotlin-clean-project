package yuresko.diffutilkotlincleanproject.adapter

import androidx.recyclerview.widget.DiffUtil
import yuresko.diffutilkotlincleanproject.Something

class DiffUtilCallback(
    private var oldList: List<Something>,
    private var newList: List<Something>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}