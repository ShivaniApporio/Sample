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

class FilterActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        textView=findViewById(R.id.textView)
        btn=findViewById(R.id.btn)
        btn.setOnClickListener {
            doSomeWork()
        }
    }
    fun doSomeWork()
    {
        Observable.just(1,2,3,4,5)
            .filter {
               return@filter it%2 == 0
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<Int>{
                override fun onComplete()=textView.append("Complete"+AppConstant.LINE_SEPARATOR)
                override fun onSubscribe(d: Disposable)=textView.append("disposable: ${d.isDisposed}"+AppConstant.LINE_SEPARATOR)
                override fun onNext(t: Int)=textView.append("onNext : ${t}"+AppConstant.LINE_SEPARATOR)
                override fun onError(e: Throwable)=textView.append("error : ${e.message}"+AppConstant.LINE_SEPARATOR)
            })
    }
}
