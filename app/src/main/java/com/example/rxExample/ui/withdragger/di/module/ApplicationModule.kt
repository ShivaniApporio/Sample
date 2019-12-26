package com.example.rxExample.ui.withdragger.di.module

import android.content.Context
import com.example.rxExample.ui.withdragger.MyApplication
import com.example.rxExample.ui.withdragger.di.DatabaseInfo
import com.example.rxExample.ui.withdragger.di.NetworkInfo
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ApplicationModule(private val application: MyApplication) {
    @Provides
    fun provideContext(): Context = application

    @Provides
    @DatabaseInfo
    fun provideDatabaeName(): String = "dbname"
    @Provides
    @NetworkInfo
    fun provideApiKey(): String = "dummyApikey"
    @Provides
    fun provideDatabseVersion(): Int = 1
    @Provides
    fun provideCompositeDisposable():CompositeDisposable= CompositeDisposable()
}