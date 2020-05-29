package yuresko.diffutilkotlincleanproject.adapter

import androidx.recyclerview.widget.DiffUtil
import yuresko.diffutilkotlincleanproject.Something

class DiffUtilCallback : DiffUtil.ItemCallback<Something>() {
    override fun areItemsTheSame(oldItem: Something, newItem: Something): Boolean {
        return oldItem is Something && newItem is Something
    }

    override fun areContentsTheSame(oldItem: Something, newItem: Something): Boolean {
        return oldItem == newItem
    }
}