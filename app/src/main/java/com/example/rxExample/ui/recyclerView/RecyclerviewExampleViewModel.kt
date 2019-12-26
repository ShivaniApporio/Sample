package com.example.rxExample.ui.recyclerView

import android.content.Context
import com.example.practice.service.NetworkService
import com.example.rxExample.ui.rx.model.User

class RecyclerviewExampleViewModel (val networkService: NetworkService){
    fun getListOfStudent(context: Context): MutableList<User> =networkService.getListOfStudent()
}