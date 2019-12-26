package com.example.rxExample.ui.withdragger.di.component

import android.app.Activity
import com.example.rxExample.ui.withdragger.di.ActivityScope
import com.example.rxExample.ui.withdragger.di.module.ActivityModule
import com.example.rxExample.ui.withdragger.ui.main.MainActivity
import dagger.Component
@ActivityScope
@Component(dependencies = [ApplicationComponent::class],modules = [ActivityModule::class] )
interface ActivityComponent {
    fun inject(activity: MainActivity)
}