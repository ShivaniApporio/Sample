package com.example.rxExample.ui.withdragger.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxExample.ui.withdragger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(val compositeDisposable: CompositeDisposable,val networkHelper: NetworkHelper):ViewModel() {
    val messagetringId:MutableLiveData<Int> =MutableLiveData()
    val messagetring:MutableLiveData<String> = MutableLiveData()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
    abstract fun onCreate()
}
