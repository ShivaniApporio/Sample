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
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SimpleActivity : AppCompatActivity() {
    companion object{
        private const val TAG="SimpleActivity"
    }
  private lateinit var btn:Button
    private  lateinit var textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
        btn=findViewById(R.id.btn);
        textView=findViewById(R.id.textView);
        btn.setOnClickListener { view ->
            doSomeTask()
        }
    }
    private fun doSomeTask()
    {


      Observable.just("Shivani","Akshst")
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(object : Observer<String>
          {
              override fun onComplete() {
                  textView.append("onComplete")
                  textView.append(AppConstant.LINE_SEPARATOR)
              }

              override fun onSubscribe(d: Disposable) {
                    Log.d(TAG,""+d.isDisposed)
                  textView.append("disposable : ${d.isDisposed}")
                  textView.append(AppConstant.LINE_SEPARATOR)
              }

              override fun onNext(t: String) {
                  textView.append(t)
                  textView.append(AppConstant.LINE_SEPARATOR)
              }

              override fun onError(e: Throwable) {
                  textView.append(e.message)
                  textView.append(AppConstant.LINE_SEPARATOR)
              }

          })
    }
}
