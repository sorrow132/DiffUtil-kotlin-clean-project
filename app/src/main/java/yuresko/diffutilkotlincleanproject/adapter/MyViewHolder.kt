package yuresko.diffutilkotlincleanproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import yuresko.diffutil_kotlin_clean_project.R
import yuresko.diffutilkotlincleanproject.Something

class MyViewHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
    ) {
    private var textView1: TextView? = itemView.findViewById(R.id.textView1)
    private var textView2: TextView? = itemView.findViewById(R.id.textView2)
    private var textView3: TextView? = itemView.findViewById(R.id.textView3)

    fun bind(test: Something) {
        textView1?.text = test.id.toString()
        textView2?.text = test.name
        textView3?.text = test.price.toString()
    }
}