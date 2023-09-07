package com.example.deltanews.newsfeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.deltanews.R
import com.example.deltanews.databinding.ActivityNewsFeedBinding
import com.example.deltanews.model.NewFeedItem

class NewsFeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNewsFeedBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_news_feed)

        val viewModel: NewsFeedViewModel = ViewModelProvider(this)[NewsFeedViewModel::class.java]

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val newsFeedRecyclerViewAdapter = NewsFeedRecyclerViewAdapter()
        binding.recyclerView.adapter = newsFeedRecyclerViewAdapter

        viewModel.fetchNewsFeed()
    }
}

@BindingAdapter("setItems")
fun setItem(recyclerView: RecyclerView, list: List<NewFeedItem>?) {
    (recyclerView.adapter as NewsFeedRecyclerViewAdapter).setNewsFeedItem(list)

}