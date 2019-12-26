package com.example.rxExample.ui.lifecycle_livedata_viewmodel.without_lifecycle

import android.content.Context
import android.os.CountDownTimer
import android.widget.Toast

class TimerWithoutLifecycle(val context: Context) {
    var timer=object : CountDownTimer(60000,3000) {
        override fun onFinish() {
        }

        override fun onTick(p0: Long) {
            Toast.makeText(context, "$p0", Toast.LENGTH_SHORT).show()

        }

    }
    fun start()
    {
        timer.start()
    }
    fun stop()
    {
        timer.cancel()
    }
}