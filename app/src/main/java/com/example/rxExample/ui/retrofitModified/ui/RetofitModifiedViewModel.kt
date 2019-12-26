package com.example.rxExample.ui.retrofitModified.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.rxExample.ui.retrofitModified.data.remote.NetworkService
import com.example.rxExample.ui.retrofitModified.data.remote.request.DummyRequest
import com.mindorks.bootcamp.instagram.data.model.Dummy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RetofitModifiedViewModel(var networkService: NetworkService) {
    companion object {
        const val TAG = "RetrofitModifiedViewModel"
    }

    val dummies = MutableLiveData<List<Dummy>>();
    fun getDummy() {
        networkService.doDummyCall(DummyRequest("123"))
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    dummies.postValue(it.data)
                },
                {
                    Log.d("###", it.message)
                }
            )
    }

}