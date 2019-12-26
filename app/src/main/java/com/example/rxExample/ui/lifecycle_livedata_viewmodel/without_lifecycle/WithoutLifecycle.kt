package com.example.rxExample.ui.lifecycle_livedata_viewmodel.without_lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxExample.R

class WithoutLifecycle : AppCompatActivity() {
    lateinit var timerWithoutLifecycle:TimerWithoutLifecycle;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_without_lifecycle)
        timerWithoutLifecycle = TimerWithoutLifecycle(applicationContext);
        timerWithoutLifecycle.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        timerWithoutLifecycle.stop()
    }
}
