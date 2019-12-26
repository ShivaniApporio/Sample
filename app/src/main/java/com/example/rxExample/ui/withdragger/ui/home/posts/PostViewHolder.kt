package com.mindorks.bootcamp.demo.ui.home.posts

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.rxExample.R
import com.example.rxExample.ui.withdragger.di.component.ViewHolderComponent
import com.example.rxExample.ui.withdragger.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.item_view_post.view.*

class PostViewHolder(parent: ViewGroup) : BaseItemViewHolder<Post, PostViewModel>(
        R.layout.item_view_post, parent) {


    override fun setupView(view: View) {

    }



    override fun setupObservers() {
        super.setupObservers()
        viewModel.data.observe(this, Observer {
            itemView.tv_message.text = it.text
        })

        itemView.setOnClickListener {
            showMessage("$adapterPosition clicked")
        }
    }

    override fun injectDependancies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)

    }
}