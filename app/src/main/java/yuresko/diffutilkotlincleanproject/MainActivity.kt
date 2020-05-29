package yuresko.diffutilkotlincleanproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import yuresko.diffutil_kotlin_clean_project.R
import yuresko.diffutilkotlincleanproject.adapter.RecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var editText: EditText

    private lateinit var recyclerView: RecyclerView

    private val repository = SomeRepository()
    private val adapter = RecyclerViewAdapter()

    private val viewModel: IViewModel = MyViewModel(repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.buttonId)
        button2 = findViewById(R.id.buttonPrice)
        button3 = findViewById(R.id.changeList)
        editText = findViewById(R.id.editText)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.items.observe(this, Observer {
            adapter.submitList(it)
        })

        button3.setOnClickListener {
            val raw = editText.text.toString()
            val values = raw.split("#")
            val index: Int = values.getOrNull(0)?.toIntOrNull() ?: 0
            val price: Int = values.getOrNull(1)?.toIntOrNull() ?: 50
            viewModel.changePrice(index, price)
        }
    }
}
