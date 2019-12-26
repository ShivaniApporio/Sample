package com.example.rxExample.ui.lifecycle_livedata_viewmodel.livedata_viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimeLivedataViewModel :ViewModel(){
      val timerData= MutableLiveData<String>()
      val timer=object :CountDownTimer(60000,3000){
        override fun onFinish() {
            timerData.postValue("finished")
        }

        override fun onTick(p0: Long) {
            timerData.postValue("$p0")

        }

    }
    fun start()
    {
        timer.start()
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}