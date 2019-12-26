package com.example.rxExample.ui.withdragger.di.component

import com.example.rxExample.ui.withdragger.di.ViewHolderScope
import com.example.rxExample.ui.withdragger.di.module.ViewHolderModule
import com.mindorks.bootcamp.demo.ui.home.posts.PostViewHolder
import dagger.Component
@ViewHolderScope
@Component(dependencies = [ApplicationComponent::class],modules = [ViewHolderModule::class])
interface ViewHolderComponent {
    fun inject(viewHolder: PostViewHolder)

}