package com.mindorks.bootcamp.demo.ui.home.posts

import com.example.rxExample.ui.withdragger.data.local.DatabaseService
import com.example.rxExample.ui.withdragger.data.remote.NetworkService
import com.example.rxExample.ui.withdragger.ui.base.BaseItemViewModel
import com.example.rxExample.ui.withdragger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PostViewModel @Inject constructor(
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val databaseService: DatabaseService,
    private val networkService: NetworkService
) : BaseItemViewModel<Post>(compositeDisposable, networkHelper) {

    override fun onCreate() {

    }
}
