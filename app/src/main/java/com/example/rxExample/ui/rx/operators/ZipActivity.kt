package com.example.rxExample.ui.rx.operators

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

class ZipActivity : AppCompatActivity() {
    companion object{
        val TAG:String="ZipActivity"
    }
    lateinit var btn: Button
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zip)
        btn = findViewById(R.id.btn)
        textView = findViewById(R.id.textView)
        btn.setOnClickListener {
            doSomeWork()
        }
    }

    @SuppressLint("CheckResult")
    fun doSomeWork() {
        Observable.zip(getFansFootballLovers(), getFansCricketLovers(),
            BiFunction<List<User>, List<User>, List<User>> { t1, t2 ->
                return@BiFunction Utils.personWhoLoveBoth(t1, t2)
            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                object : Observer<List<User>> {

                    override fun onSubscribe(d: Disposable) {
                        Log.e(TAG, " onSubscribe : " + d.isDisposed)
                    }

                    override fun onNext(userList: List<User>) {
                        textView.append(" onNext")
                        textView.append(AppConstant.LINE_SEPARATOR)
                        for (user in userList) {
                            textView.append(" firstname : ${user.name}")
                            textView.append(AppConstant.LINE_SEPARATOR)
                        }
                        Log.e(TAG, " onNext : " + userList.size)
                    }

                    override fun onError(e: Throwable) {
                        textView.append(" onError : " + e.message)
                        textView.append(AppConstant.LINE_SEPARATOR)
                        Log.e(TAG, " onError : " + e.message)
                    }

                    override fun onComplete() {
                        textView.append(" onComplete")
                        textView.append(AppConstant.LINE_SEPARATOR)
                        Log.e(TAG, " onComplete")
                    }
                }
            )
    }

    fun getFansCricketLovers(): Observable<List<User>> {
        return  Observable.create(ObservableOnSubscribe<List<User>> {
            it.onNext(Utils.personWhoLoveCricket())
            it.onComplete()
        }).subscribeOn(Schedulers.io())
//        return Observable.create<List<User>> {
//            it.onNext(Utils.personWhoLoveCricket())
//        }.subscribeOn(Schedulers.io())
    }

    fun getFansFootballLovers(): Observable<List<User>> {
        return  Observable.create(ObservableOnSubscribe<List<User>> {
            it.onNext(Utils.personWhoLoveFootball())
            it.onComplete()

        }).subscribeOn(Schedulers.io())
//        return Observable.create<List<User>> {
//            it.onNext(Utils.personWhoLoveFootball())
//        }.subscribeOn(Schedulers.io())
    }
}
