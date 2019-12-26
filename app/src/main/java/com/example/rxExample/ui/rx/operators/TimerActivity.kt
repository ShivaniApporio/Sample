package com.example.rxExample.ui.rx.operators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.rxExample.R
import com.example.rxExample.ui.rx.util.AppConstant
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class TimerActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        textView=findViewById(R.id.textView)
        btn=findViewById(R.id.btn)
        btn.setOnClickListener {
            doSomeWork()
        }
    }
    fun doSomeWork() {
        Observable.timer(5, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Long> {
                override fun onComplete()= textView.append("onComplete"+AppConstant.LINE_SEPARATOR)
                override fun onSubscribe(d: Disposable)=textView.append("Disposable : ${d.isDisposed}"+AppConstant.LINE_SEPARATOR)
                override fun onError(e: Throwable)= textView.append("error : ${e.message}"+AppConstant.LINE_SEPARATOR)
                override fun onNext(t: Long)=textView.append("onNext:${t}"+AppConstant.LINE_SEPARATOR)
            })
    }
}
