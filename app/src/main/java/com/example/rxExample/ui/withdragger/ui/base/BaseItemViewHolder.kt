package com.example.rxExample.ui.withdragger.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.rxExample.ui.withdragger.MyApplication
import com.example.rxExample.ui.withdragger.di.component.DaggerViewHolderComponent
import com.example.rxExample.ui.withdragger.di.component.ViewHolderComponent
import com.example.rxExample.ui.withdragger.di.module.ViewHolderModule
import javax.inject.Inject

abstract class BaseItemViewHolder<T : Any, VM : BaseItemViewModel<T>>(@LayoutRes layoutID: Int, parent: ViewGroup) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutID, parent, false)), LifecycleOwner {
    init {
        onCreate()
    }

    @Inject
    lateinit var viewModel: VM
    @Inject
    lateinit var lifecycleRegistry: LifecycleRegistry

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    fun bind(data: T) {
        viewModel.updateData(data)
    }

    private fun onCreate() {
        injectDependancies(buildviewHolderDependancy())
        lifecycleRegistry.markState(Lifecycle.State.INITIALIZED)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
        setupObservers()
        setupView(itemView)
    }
    fun onStart()
    {
        lifecycleRegistry.markState(Lifecycle.State.STARTED)
        lifecycleRegistry.markState(Lifecycle.State.RESUMED)
    }
    fun onStop()
    {
        lifecycleRegistry.markState(Lifecycle.State.STARTED)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
    }
    fun onDestroy()
    {
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)

    }
    protected open fun setupObservers()
    {
        viewModel.messagetringId.observe(this, Observer {

        })
        viewModel.messagetring.observe(this, Observer {

        })
    }
    fun showMessage(message: String) = Toast.makeText(itemView.context, message, Toast.LENGTH_SHORT).show()

    fun showMessage(@StringRes resId: Int) = showMessage(itemView.context.getString(resId))

    private fun buildviewHolderDependancy(): ViewHolderComponent {
        return DaggerViewHolderComponent.builder()
            .applicationComponent((itemView.context.applicationContext as MyApplication).applicationComponent)
            .viewHolderModule(ViewHolderModule(this))
            .build()
    }

    protected abstract fun injectDependancies(viewHolderComponent: ViewHolderComponent)
    abstract fun setupView(view: View)


}