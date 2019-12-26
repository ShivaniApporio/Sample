package com.example.rxExample.ui.withdragger.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.rxExample.ui.withdragger.data.local.DatabaseService
import com.example.rxExample.ui.withdragger.data.remote.NetworkService
import com.example.rxExample.ui.withdragger.ui.base.BaseViewModel
import com.example.rxExample.ui.withdragger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel(
    var databaseService: DatabaseService, var networkService: NetworkService, compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(compositeDisposable,networkHelper) {
    val testdata: MutableLiveData<String> = MutableLiveData()
    fun getsomedata(): String {
        return databaseService.databaseName + "  " + networkService.dummyData
    }

    override fun onCreate() {
        testdata.postValue("This is for testing only")
    }
}