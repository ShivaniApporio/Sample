package com.example.rxExample.ui.lifecycle_livedata_viewmodel

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.example.rxExample.R
import com.example.rxExample.ui.lifecycle_livedata_viewmodel.livedata_viewmodel.LiveDataViewModel
import com.example.rxExample.ui.lifecycle_livedata_viewmodel.with_lifecycle.WithLifecycle
import com.example.rxExample.ui.lifecycle_livedata_viewmodel.without_lifecycle.WithoutLifecycle

import kotlinx.android.synthetic.main.activity_lifecycle_example.*

class LifecycleExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_example)
    }
    fun withOutLifeCycle(view: View)
    {
        startActivity(Intent(this,WithoutLifecycle::class.java))
    }
    fun withLifeCycle(view: View)
    {
        startActivity(Intent(this,WithLifecycle::class.java))
    }
    fun livedata_viewmodel(view: View)
    {
        startActivity(Intent(this,LiveDataViewModel::class.java))

    }
}
