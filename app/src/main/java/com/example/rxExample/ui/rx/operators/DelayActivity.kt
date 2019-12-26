package com.example.rxExample.ui.rx.operators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.rxExample.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class DelayActivity : AppCompatActivity() {
    lateinit var btn: Button
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delay)
        btn = findViewById(R.id.btn)
        textView = findViewById(R.id.textView)
        btn.setOnClickListener {
            doSomeWork()
        }
    }

    fun doSomeWork() {
        Observable.just("A","B","C")
            .delay(2,TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<String>{
                override fun onComplete() {
                }

                override fun onError(e: Throwable) {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: String) {
                    Log.e("onNext",t)
                }
            })

    }
}
