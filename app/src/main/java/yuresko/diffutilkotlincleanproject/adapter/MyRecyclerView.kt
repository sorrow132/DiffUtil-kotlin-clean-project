package yuresko.diffutilkotlincleanproject.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import yuresko.diffutilkotlincleanproject.Something

class MyRecyclerView(private val infoList: List<Something>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val arr: MutableList<Something> = mutableListOf()

    init {
        arr.addAll(infoList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(parent)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount() = infoList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder) {
            holder.bind(infoList[position])
        }
    }

    fun swap(arr: List<Something>) {
        val diffCallback = DiffUtilCallback(this.arr, arr)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.arr.clear()
        this.arr.addAll(arr)
        diffResult.dispatchUpdatesTo(this)
    }
}