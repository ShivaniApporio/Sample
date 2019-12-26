package com.example.rxExample.ui.withdragger.ui.base

import androidx.lifecycle.MutableLiveData
import com.example.rxExample.ui.withdragger.di.component.DaggerViewHolderComponent
import com.example.rxExample.ui.withdragger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

abstract class BaseItemViewModel<T:Any>(compositeDisposable: CompositeDisposable, networkHelper:NetworkHelper)
    :BaseViewModel(compositeDisposable,networkHelper){
    val data:MutableLiveData<T> = MutableLiveData()

    fun onManualClear()=onCleared()

    fun updateData(data:T)
    {
        this.data.postValue(data)
    }


}