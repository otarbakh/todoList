package com.example.todolist

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    var oto = "misho"
    var misho = "oto"
    var mesame = "mesame"


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvTodo.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvTodo.adapter = todoListAdapter(
            mutableListOf<todo>()
        ).apply {
            binding.btnAddTask.setOnClickListener {

                if (binding.etAddTask.text.isNotEmpty()) {
                    todoList.add(todo(binding.etAddTask.text.toString()))
                    notifyDataSetChanged()
                    binding.etAddTask.text.clear()

                } else {
                    binding.etAddTask.hint = "ENTER TASK !"
                    binding.etAddTask.setHintTextColor(Color.RED)
                    binding.etAddTask.setTextColor(Color.RED)
                }
                setOnItemCLickListener { task: todo, i: Int ->
                    todoList.remove(task)
                    notifyItemChanged(0)
                    notifyItemRangeChanged(0, 5)
                }
            }
        }
    }
}

