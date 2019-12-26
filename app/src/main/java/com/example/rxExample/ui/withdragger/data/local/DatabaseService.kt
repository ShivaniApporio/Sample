package com.example.rxExample.ui.withdragger.data.local

import android.content.Context
import com.example.rxExample.ui.withdragger.di.DatabaseInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseService @Inject constructor (val context: Context, @DatabaseInfo val databaseName:String, val databaseVersion:Int)
{
    val dummyData : String get()= databaseName
}