package yuresko.diffutilkotlincleanproject

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import yuresko.diffutil_kotlin_clean_project.R
import yuresko.diffutilkotlincleanproject.adapter.MyRecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button

    private lateinit var recyclerView: RecyclerView

    private val repository = SomeRepository()
    private val adapter = MyRecyclerView(repository.arrSortedById)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.buttonId)
        button2 = findViewById(R.id.buttonPrice)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        button1.setOnClickListener {
            adapter.swap(repository.arrSortedById)
        }

        button2.setOnClickListener {
            adapter.swap(repository.arrSortedByPrice)
        }

    }
}
