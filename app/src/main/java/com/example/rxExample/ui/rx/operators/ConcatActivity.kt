package com.example.rxExample.ui.rx.operators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.rxExample.R
import com.example.rxExample.ui.rx.util.AppConstant
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class ConcatActivity : AppCompatActivity() {
  lateinit var btn:Button
    lateinit var textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concat)
        btn=findViewById(R.id.btn)
        textView=findViewById(R.id.textView)
        btn.setOnClickListener {
            doSomeWork()
        }
    }
    fun  doSomeWork()
    {
        val ObservableA=Observable.just("A","B","C")
        val ObservableB=Observable.just("D","E","F")
        Observable.concat(ObservableA,ObservableB)
            .subscribe(object :Observer<String>{
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: String) {
                    Log.e("####","onNext : ${t}"+AppConstant.LINE_SEPARATOR)
                }

                override fun onError(e: Throwable) {
                }

            })
    }
}
