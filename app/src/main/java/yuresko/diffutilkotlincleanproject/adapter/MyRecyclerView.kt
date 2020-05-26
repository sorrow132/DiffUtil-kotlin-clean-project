package yuresko.diffutilkotlincleanproject.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import yuresko.diffutilkotlincleanproject.MyDataClass

class MyRecyclerView(private val infoList: List<MyDataClass>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
}