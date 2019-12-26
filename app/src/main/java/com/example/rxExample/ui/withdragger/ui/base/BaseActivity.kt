package com.example.rxExample.ui.withdragger.ui.base

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.rxExample.ui.withdragger.MyApplication
import com.example.rxExample.ui.withdragger.di.component.ActivityComponent
import com.example.rxExample.ui.withdragger.di.component.DaggerActivityComponent
import com.example.rxExample.ui.withdragger.di.module.ActivityModule
import com.example.rxExample.ui.withdragger.ui.main.MainViewModel
import javax.inject.Inject

abstract class BaseActivity<VM:BaseViewModel> : AppCompatActivity() {
    @Inject
    lateinit var viewModel: VM
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDepandencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutID())
        setupObservables()
        setupView(savedInstanceState)
        viewModel.onCreate()

    }
   protected open fun setupObservables(){
       viewModel.messagetringId.observe(this, Observer {
           showmessage(it)
       })
       viewModel.messagetring.observe(this, Observer {
           showmessage(it)
       }
       )

   }
    private fun showmessage(message:String)= Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    private fun showmessage(resId:Int)= showmessage(getString(resId))
   protected open fun goBack()=onBackPressed()
   private fun buildActivityComponent(): ActivityComponent =
        DaggerActivityComponent.builder()
            .applicationComponent((application as MyApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
   protected abstract fun setupView(savedInstanceState: Bundle?)
   protected abstract fun injectDepandencies(activityComponent: ActivityComponent)

    @LayoutRes
    protected abstract fun provideLayoutID(): Int

    override fun onBackPressed() {
      if(supportFragmentManager.backStackEntryCount>0)
          supportFragmentManager.popBackStackImmediate()
       else super.onBackPressed()
    }
}