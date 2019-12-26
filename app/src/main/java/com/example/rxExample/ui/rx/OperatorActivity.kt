package com.example.rxExample.ui.rx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rxExample.R
import com.example.rxExample.ui.rx.operators.*

class OperatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operator)
    }
    fun startSimpleActivity(view: View) = startActivity(Intent(this, SimpleActivity::class.java))

    fun startMapActivity(view: View) = startActivity(Intent(this, MapActivity::class.java))

    fun startZipActivity(view: View) = startActivity(Intent(this, ZipActivity::class.java))

    fun startTimerActivity(view: View)=startActivity(Intent(this, TimerActivity::class.java))

    fun startFilterActivity(view: View) =startActivity(Intent(this, FilterActivity::class.java))

    fun startMergeActivity(view: View) =startActivity(Intent(this, MergeActivity::class.java))

    fun startConcatActivity(view: View)=startActivity(Intent(this, ConcatActivity::class.java))

    fun startDelayActivity(view: View)=startActivity(Intent(this, DelayActivity::class.java))
}
