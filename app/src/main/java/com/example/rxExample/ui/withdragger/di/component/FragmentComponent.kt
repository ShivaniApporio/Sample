package com.example.rxExample.ui.withdragger.di.component

import com.example.rxExample.ui.withdragger.di.FragmentScope
import com.example.rxExample.ui.withdragger.di.module.FragmentModule
import com.example.rxExample.ui.withdragger.ui.home.HomeFragment
import dagger.Component
@FragmentScope
@Component(modules = [FragmentModule::class], dependencies = [ApplicationComponent::class])
interface FragmentComponent {
    fun inject(homeFragment: HomeFragment)
}