package com.example.rxExample.ui.rx.operators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.rxExample.R
import com.example.rxExample.ui.rx.model.ApiUser
import com.example.rxExample.ui.rx.model.User
import com.example.rxExample.ui.rx.util.AppConstant
import com.example.rxExample.ui.rx.util.Utils
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MapActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        btn = findViewById(R.id.btn)
        textView = findViewById(R.id.textView)
        btn.setOnClickListener { view ->
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        Observable.create<List<ApiUser>>(object : ObservableOnSubscribe<List<ApiUser>> {
            override fun subscribe(emitter: ObservableEmitter<List<ApiUser>>) {
                emitter.onNext(Utils.getApiUserList())
            }
        }).map {
            Log.e("inside map", Thread.currentThread().getName())
            return@map Utils.convertApiUserListToUserList(it)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<User>> {
                override fun onComplete() {
                    Log.e("###", "onComplete")
                }

                override fun onError(e: Throwable) {

                    Log.e("inside error", e.message + "  " + Thread.currentThread().getName())
                    textView.append(e.message)
                    textView.append(AppConstant.LINE_SEPARATOR)

                }

                override fun onNext(t: List<User>) {
                    Log.e("####", "next" + "  " + Thread.currentThread().getName())
                    for (user in t) {
                        textView.append(user.name)
                        textView.append(AppConstant.LINE_SEPARATOR)
                    }

                }


                override fun onSubscribe(d: Disposable) {
                    Thread.currentThread().getName()
                    Log.e("####", "" + d.isDisposed)

                }

            })
    }

}




