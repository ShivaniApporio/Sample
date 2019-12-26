package com.example.rxExample.ui.retrofitModified.ui

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer
import com.example.rxExample.R
import com.example.rxExample.ui.retrofitModified.data.remote.NetworkService
import com.example.rxExample.ui.retrofitModified.data.remote.Networking

import kotlinx.android.synthetic.main.activity_retrofit_modified.*

class RetrofitModifiedActivity : AppCompatActivity() {
  lateinit var networking: NetworkService;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_modified)
        setSupportActionBar(toolbar)
        networking=Networking.create("BLUE19QVVAPP","https://api.projects.bootcamp.mindorks.com/batch/blue/"
        ,application.cacheDir,10*1024*1024);
        var retrofitModifiedViewModel:RetofitModifiedViewModel=RetofitModifiedViewModel(networking);
        retrofitModifiedViewModel.getDummy()
        retrofitModifiedViewModel.dummies.observe(this, Observer {
            Toast.makeText(applicationContext,it.toString(),Toast.LENGTH_LONG).show()
        })

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}
