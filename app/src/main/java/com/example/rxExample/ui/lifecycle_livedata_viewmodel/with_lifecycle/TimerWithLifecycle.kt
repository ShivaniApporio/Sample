package com.example.rxExample.ui.lifecycle_livedata_viewmodel.with_lifecycle

import android.content.Context
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import java.util.*

class TimerWithLifecycle(context: Context, lifecycleOwner: LifecycleOwner) : LifecycleObserver {
    private var started = false;
    private val lifecycle = lifecycleOwner.lifecycle

    init {
        lifecycle.addObserver(this)
    }

    private val timer = object : CountDownTimer(60000, 3000) {
        override fun onFinish() {

        }

        override fun onTick(p0: Long) {
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED))
                Toast.makeText(context, "$p0", Toast.LENGTH_SHORT).show()

        }

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        if (!started) {
            started = true;
            timer.start()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stop() {
        timer.cancel()
    }
}