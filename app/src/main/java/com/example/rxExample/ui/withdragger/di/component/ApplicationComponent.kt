package com.example.rxExample.ui.withdragger.di.component

import android.content.Context
import com.example.rxExample.ui.withdragger.MyApplication
import com.example.rxExample.ui.withdragger.data.local.DatabaseService
import com.example.rxExample.ui.withdragger.data.remote.NetworkService
import com.example.rxExample.ui.withdragger.di.module.ApplicationModule
import com.example.rxExample.ui.withdragger.utils.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules =[ApplicationModule::class])
interface ApplicationComponent {
    fun inject(appliction: MyApplication)
    fun getContext(): Context
    fun getDatabaseService():DatabaseService
    fun  getNetworkService():NetworkService
    fun  getNetworkHelper():NetworkHelper
    fun  getCompositeDisposable():CompositeDisposable
}