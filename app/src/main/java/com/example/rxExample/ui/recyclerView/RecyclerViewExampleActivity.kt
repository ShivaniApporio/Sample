package com.example.rxExample.ui.recyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.service.NetworkService
import com.example.rxExample.R
import com.example.rxExample.ui.rx.model.User

class RecyclerViewExampleActivity : AppCompatActivity() {
lateinit var recycler_view:RecyclerView;
    lateinit var btn_add:Button
    lateinit var btn_getlist:Button
    lateinit var recyclerviewExampleViewModel: RecyclerviewExampleViewModel
    lateinit var userList: MutableList<User>
    lateinit var recyclerViewExampleAdapter: RecyclerViewExampleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_example)
        init()
        setupRecyclerView()
    }
    private fun init()
    {
        btn_getlist=findViewById(R.id.btn_getlist)
        btn_add=findViewById(R.id.btn_add)
        recycler_view=findViewById(R.id.recycler_view)
        recyclerviewExampleViewModel= RecyclerviewExampleViewModel(NetworkService())
        btn_getlist.setOnClickListener {
            userList= recyclerviewExampleViewModel.getListOfStudent(this)
            recyclerViewExampleAdapter.updatedata(userList)
        }
        btn_add.setOnClickListener {
            userList.add(1,User(userList.size.toLong(),"shivani",false))
            recyclerViewExampleAdapter.notifyItemInserted(userList.size)
            recycler_view.scrollToPosition(userList.size-1)
        }
    }
    private fun setupRecyclerView()
    {
        recyclerViewExampleAdapter=RecyclerViewExampleAdapter()
        recycler_view.adapter=recyclerViewExampleAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
}


