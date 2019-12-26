package com.example.rxExample.ui.rx.operators

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.rxExample.R
import com.example.rxExample.ui.rx.model.User
import com.example.rxExample.ui.rx.util.AppConstant
import com.example.rxExample.ui.rx.util.Utils
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MergeActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_merge)
        textView=findViewById(R.id.textView)
        btn=findViewById(R.id.btn)
        btn.setOnClickListener {
            doSomeWork()
        }
    }
    @SuppressLint("CheckResult")
    fun doSomeWork()
    {
        Observable.merge(getCricketObservable(),getFootballObservable())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object:Observer<List<User>>{
                override fun onSubscribe(d: Disposable)=textView.append("Disposable : ${d.isDisposed}"+AppConstant.LINE_SEPARATOR)
                override fun onNext(t: List<User>) {
                    textView.append("onNext"+AppConstant.LINE_SEPARATOR)
                    for(user in t) textView.append(user.name+AppConstant.LINE_SEPARATOR)
                }
                override fun onError(e: Throwable) = textView.append("onerror : ${e.message}")
                override fun onComplete() = textView.append("onComplete")
            }
            )

    }
    private fun getCricketObservable():Observable<List<User>>{
       return Observable.create(ObservableOnSubscribe<List<User>> {
            it.onNext(Utils.personWhoLoveCricket())
        }).subscribeOn(Schedulers.io())
    }
    private fun getFootballObservable():Observable<List<User>>{
        return Observable.create(ObservableOnSubscribe<List<User>> {
            it.onNext(Utils.personWhoLoveFootball())
        }).subscribeOn(Schedulers.io())
    }
}
