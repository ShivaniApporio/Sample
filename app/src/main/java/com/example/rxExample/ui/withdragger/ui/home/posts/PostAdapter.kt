package com.mindorks.bootcamp.demo.ui.home.posts

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.example.rxExample.ui.withdragger.ui.base.BaseAdapter


class PostAdapter(
        parentLifecycle: Lifecycle,
        posts: ArrayList<Post>
) : BaseAdapter<Post, PostViewHolder>(parentLifecycle, posts) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =

            PostViewHolder(parent)
    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
    }
}