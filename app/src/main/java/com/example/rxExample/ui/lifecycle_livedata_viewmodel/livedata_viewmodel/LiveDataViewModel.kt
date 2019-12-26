package com.example.rxExample.ui.lifecycle_livedata_viewmodel.livedata_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.rxExample.R

class LiveDataViewModel : AppCompatActivity() {
lateinit var viewModel: TimeLivedataViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_view_model)
        viewModel= ViewModelProviders.of(this).get(TimeLivedataViewModel::class.java)
        viewModel.timerData.observe(this, Observer {
            Toast.makeText(applicationContext,it,Toast.LENGTH_SHORT).show()
        })
        viewModel.start();
    }
}
