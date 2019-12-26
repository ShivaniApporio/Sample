package com.example.rxExample.ui.withdragger.di.module

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.example.rxExample.ui.withdragger.data.local.DatabaseService
import com.example.rxExample.ui.withdragger.data.remote.NetworkService
import com.example.rxExample.ui.withdragger.ui.base.BaseActivity
import com.example.rxExample.ui.withdragger.ui.main.MainViewModel
import com.example.rxExample.ui.withdragger.utils.NetworkHelper
import com.example.rxExample.ui.withdragger.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private  val activity: BaseActivity<*>) {

    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun providemainViewModel(compositeDisposable: CompositeDisposable,databaseService: DatabaseService
    ,networkService: NetworkService,networkHelper: NetworkHelper):MainViewModel= ViewModelProviders.of(activity,
        ViewModelProviderFactory(MainViewModel::class){
            MainViewModel(databaseService,networkService,compositeDisposable,networkHelper)

    }).get(MainViewModel::class.java)
}