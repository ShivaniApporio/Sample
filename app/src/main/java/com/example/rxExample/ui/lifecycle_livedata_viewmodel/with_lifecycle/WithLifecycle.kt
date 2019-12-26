package com.example.rxExample.ui.lifecycle_livedata_viewmodel.with_lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxExample.R

class WithLifecycle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_lifecycle)
        var timerWithLifecycle=TimerWithLifecycle(application,this)
    }
}
