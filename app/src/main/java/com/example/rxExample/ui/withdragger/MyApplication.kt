package com.example.rxExample.ui.withdragger

import android.app.Application
import android.widget.Toast
import com.example.rxExample.ui.withdragger.data.local.DatabaseService
import com.example.rxExample.ui.withdragger.data.remote.NetworkService
import com.example.rxExample.ui.withdragger.di.component.ApplicationComponent
import com.example.rxExample.ui.withdragger.di.component.DaggerApplicationComponent
import com.example.rxExample.ui.withdragger.di.module.ApplicationModule
import javax.inject.Inject

class MyApplication (): Application()
{
    public lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        getDependancies()
    }
    private fun getDependancies()
    {
        applicationComponent=  DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)

    }
}