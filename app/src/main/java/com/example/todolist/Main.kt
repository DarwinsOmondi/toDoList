package com.example.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var etTodoTitle: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        initializeUI()

        // Set up RecyclerView
        setUpRecyclerView()

        // Set up Add button click listener
        setUpAddButton()

        // Set up Clear button click listener
        setUpClearButton()
    }

    private fun initializeUI() {
        todoAdapter = TodoAdapter(mutableListOf())
        etTodoTitle = findViewById(R.id.etTodoTitle)
    }

    private fun setUpRecyclerView() {
        val rvTodoItem = findViewById<RecyclerView>(R.id.rvTodoItems)
        rvTodoItem.adapter = todoAdapter
        rvTodoItem.layoutManager = LinearLayoutManager(this)
    }

    private fun setUpAddButton() {
        val addButton = findViewById<Button>(R.id.addbutton)
        addButton.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()

            if (todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }
    }

    private fun setUpClearButton() {
        val clearButton = findViewById<Button>(R.id.clearbutton)
        clearButton.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}

