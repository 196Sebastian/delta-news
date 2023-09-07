package com.example.deltanews

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.deltanews.model.NewFeedItem
import com.example.deltanews.newsfeed.NewsFeedRecyclerViewAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("setItems")
fun setItem(recyclerView: RecyclerView, list: List<NewFeedItem>?) {
    (recyclerView.adapter as NewsFeedRecyclerViewAdapter).setNewsFeedItem(list)
}

@BindingAdapter("loadWithPicasso")
fun loadWithPicasso(imageView: ImageView, imageUrl: String) {
    Picasso.get().load(imageUrl).into(imageView)
}