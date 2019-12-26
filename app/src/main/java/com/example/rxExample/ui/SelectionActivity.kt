package com.example.rxExample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.example.rxExample.R
import com.example.rxExample.ui.lifecycle_livedata_viewmodel.livedata_viewmodel.LiveDataViewModel
import com.example.rxExample.ui.lifecycle_livedata_viewmodel.with_lifecycle.WithLifecycle
import com.example.rxExample.ui.lifecycle_livedata_viewmodel.without_lifecycle.WithoutLifecycle
import com.example.rxExample.ui.recyclerView.RecyclerViewExampleActivity
import com.example.rxExample.ui.retrofit.RetrofitActivity
import com.example.rxExample.ui.retrofitModified.ui.RetrofitModifiedActivity
import com.example.rxExample.ui.rx.OperatorActivity
import com.example.rxExample.ui.rx.networking.NetwokingActivity
import com.example.rxExample.ui.withdragger.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_selection.*

class SelectionActivity : AppCompatActivity() {
    companion object{
        val TAG:String="SelectionActivity"
    }
    lateinit var edt:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)
         edt=findViewById<EditText>(R.id.edt);
        Log.e(TAG,"onCreate")
       // if(savedInstanceState!=null)
//        {
//            edt.setText(savedInstanceState.getString("data"))
//        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("####","onSaveInstance")
        outState.putString("data", edt.text.toString());

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e("####","onRestoreInstance")

        edt.setText(savedInstanceState.getString("data"))
    }
    fun startOperatorsActivity(view: View)=startActivity(Intent(this, OperatorActivity::class.java))

    fun  startNetworkingActivity(view: View)=startActivity(Intent(this, NetwokingActivity::class.java))
    fun  startSearchActivity(view: View)=null

    fun recyclerViewActivity(view: View)=startActivity(Intent(this,RecyclerViewExampleActivity::class.java))
    fun withoutLifecycleActivity(view: View)=startActivity(Intent(this,WithoutLifecycle::class.java))
    fun withLifecycleActivity(view: View)=startActivity(Intent(this,WithLifecycle::class.java))
    fun livedataViewmodelActivity(view: View)=startActivity(Intent(this,LiveDataViewModel::class.java))
    fun retrofitActivity(view: View)=startActivity(Intent(this,RetrofitActivity::class.java))
    fun retofitModified(view: View)=startActivity(Intent(this,RetrofitModifiedActivity::class.java))
    fun  withDagger(view: View)=startActivity(Intent(this,MainActivity::class.java))
    override fun onStart() {
        super.onStart()
        Log.e(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG,"onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.e(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG,"onDestroy")

    }

    override fun finish() {
        super.finish()
        Log.e(TAG,"onFinish")

    }
    override fun onRestart() {
        super.onRestart()
        Log.e(TAG,"onRestart")

    }


}
