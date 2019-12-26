package com.example.rxExample.ui.withdragger.utils

import android.content.Context
import javax.inject.Inject

class NetworkHelper @Inject constructor(val context: Context) {
    val isNetworkConnection : Boolean get() {
        return false
    }
}