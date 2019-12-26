package com.example.rxExample.ui.withdragger.di.module

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(val fragment: Fragment) {
    @Provides
    fun provideContext(): Context? =fragment.context
}