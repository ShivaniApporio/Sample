package com.example.rxExample.ui.withdragger.ui.home

import androidx.lifecycle.MutableLiveData
import com.example.rxExample.ui.withdragger.data.local.DatabaseService
import com.example.rxExample.ui.withdragger.data.remote.NetworkService
import com.example.rxExample.ui.withdragger.utils.NetworkHelper
import com.mindorks.bootcamp.demo.ui.home.posts.Post
import javax.inject.Inject

class HomeViewModel @Inject constructor(val databaseService: DatabaseService,val networkService: NetworkService,val networkHelper: NetworkHelper) {
 fun getSomeData():String
 {
     return   databaseService.databaseName+" "+networkService.dummyData+" "+networkHelper.isNetworkConnection
 }
    val testData = MutableLiveData<List<Post>>()

     fun onCreate() {
        testData.postValue(listOf(
            Post("Test 1"),
            Post("Test 2"),
            Post("Test 3"),
            Post("Test 4"),
            Post("Test 5"),
            Post("Test 6"),
            Post("Test 7")
        ))
    }
}