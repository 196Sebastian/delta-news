package com.example.deltanews

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.deltanews.model.NewFeedItem
import com.example.deltanews.newsfeed.NewsFeedRecyclerViewAdapter

@BindingAdapter("setItems")
fun setItem(recyclerView: RecyclerView, list: List<NewFeedItem>?) {
    (recyclerView.adapter as NewsFeedRecyclerViewAdapter).setNewsFeedItem(list)

}