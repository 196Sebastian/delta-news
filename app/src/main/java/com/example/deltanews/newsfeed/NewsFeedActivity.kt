package com.example.deltanews.newsfeed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.deltanews.R
import com.example.deltanews.databinding.ActivityNewsFeedBinding
import com.example.deltanews.details.DetailActivity
import java.lang.ref.WeakReference

class NewsFeedActivity : AppCompatActivity(), NewsFeedRecyclerViewAdapter.NewsFeedInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNewsFeedBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_news_feed)

        val viewModel: NewsFeedViewModel = ViewModelProvider(this)[NewsFeedViewModel::class.java]

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val newsFeedRecyclerViewAdapter = NewsFeedRecyclerViewAdapter(WeakReference(this))
        binding.recyclerView.adapter = newsFeedRecyclerViewAdapter

        viewModel.fetchNewsFeed()
    }

    override fun onClick(url: String) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.ARG_URL, url)
        }

        startActivity(intent)
    }
}