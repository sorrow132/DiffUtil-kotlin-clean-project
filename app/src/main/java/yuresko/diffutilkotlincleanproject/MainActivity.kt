package yuresko.diffutilkotlincleanproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import yuresko.diffutil_kotlin_clean_project.R
import yuresko.diffutilkotlincleanproject.adapter.MyRecyclerView

class MainActivity : AppCompatActivity() {
    private var arr: MutableList<MyDataClass> = mutableListOf()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        arr.add(MyDataClass(1, "one", 32))
        arr.add(MyDataClass(2, "two", 331))
        arr.add(MyDataClass(3, "three", 31))
        arr.add(MyDataClass(4, "four", 354))
        arr.add(MyDataClass(5, "five", 344))
        arr.add(MyDataClass(6, "six", 466))
        arr.add(MyDataClass(7, "seven", 54))
        arr.add(MyDataClass(8, "eight", 676))
        arr.add(MyDataClass(9, "nine", 56))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerView(arr)

    }
}
