package com.example.rxExample.ui.withdragger.data.remote

import android.content.Context
import com.example.rxExample.ui.withdragger.di.NetworkInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkService  @Inject constructor(private val context: Context,@NetworkInfo private val apikey:String)
{
    val dummyData:String get() = apikey
}