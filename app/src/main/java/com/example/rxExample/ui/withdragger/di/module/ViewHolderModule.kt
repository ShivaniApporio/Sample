package com.example.rxExample.ui.withdragger.di.module

import androidx.lifecycle.LifecycleRegistry
import com.example.rxExample.ui.withdragger.di.ViewHolderScope
import com.example.rxExample.ui.withdragger.di.component.DaggerViewHolderComponent
import com.example.rxExample.ui.withdragger.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private  val viewHolder:BaseItemViewHolder<*,*>) {

    @Provides
    @ViewHolderScope
    fun provideLifecycleRegistery():LifecycleRegistry = LifecycleRegistry(viewHolder)

}