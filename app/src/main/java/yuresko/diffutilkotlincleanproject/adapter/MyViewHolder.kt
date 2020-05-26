package yuresko.diffutilkotlincleanproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import yuresko.diffutil_kotlin_clean_project.R
import yuresko.diffutilkotlincleanproject.MyDataClass

class MyViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
) {
    var textView1: TextView? = itemView.findViewById(R.id.textView1)
    var textView2: TextView? = itemView.findViewById(R.id.textView2)

    fun bind(test: MyDataClass) {
        textView1?.text = test.name
        textView2?.text = test.price.toString()
    }
}