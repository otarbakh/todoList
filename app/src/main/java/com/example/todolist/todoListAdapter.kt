package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TodoRecycleBinding

class todoListAdapter(val todoList:MutableList<todo>): RecyclerView.Adapter<todoListViewHolder>(){
    private lateinit var itemClickListener: (todo,Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoListViewHolder {
        val binding =
            TodoRecycleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return todoListViewHolder(binding)
    }
    fun setOnItemCLickListener(clickListener: (todo,Int) -> Unit) {
        itemClickListener = clickListener
    }
    override fun onBindViewHolder(holder: todoListViewHolder, position: Int) {
        val task = todoList[position]
        holder.binding.taskName.text = task.taskName

//        val textView = holder.itemView.findViewById<TextView>(R.id.taskName)
//        textView.text = task.taskName
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

}

class todoListViewHolder(val binding: TodoRecycleBinding):RecyclerView.ViewHolder(binding.root){

}
data class todo(
    val taskName:String,
)


