package com.example.rxExample.ui.withdragger.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.rxExample.R
import com.example.rxExample.ui.withdragger.MyApplication
import com.example.rxExample.ui.withdragger.data.local.DatabaseService
import com.example.rxExample.ui.withdragger.di.component.ActivityComponent
import com.example.rxExample.ui.withdragger.di.component.DaggerActivityComponent
import com.example.rxExample.ui.withdragger.di.module.ActivityModule
import com.example.rxExample.ui.withdragger.ui.base.BaseActivity
import com.example.rxExample.ui.withdragger.ui.home.HomeFragment
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {
 @Inject
 lateinit var mainViewModel: MainViewModel
    companion object{
        val TAG:String="MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG,"onCreate")
    }

    override fun setupView(savedInstanceState: Bundle?) {
        addHomeFragment()
    }

    override fun setupObservables() {
        super.setupObservables()
        viewModel.testdata.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
    }
    override fun injectDepandencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun provideLayoutID(): Int =R.layout.activity_main2

    fun addHomeFragment()
    {
        if(supportFragmentManager.findFragmentByTag(HomeFragment.TAG)==null)
        {
            supportFragmentManager.beginTransaction()
                .add(R.id.container_fragment,HomeFragment.newInstance(),HomeFragment.TAG)
                .commit()
        }
    }
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


//    fun  getDependancies()
//    {
//        DaggerActivityComponent.builder()
//            .applicationComponent((application as MyApplication).applicationComponent)
//            .activityModule(ActivityModule(this))
//            .build()
//            .inject(this)
//    }
}
