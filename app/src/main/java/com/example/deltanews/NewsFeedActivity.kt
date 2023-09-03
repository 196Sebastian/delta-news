package com.example.deltanews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.deltanews.databinding.ActivityNewsFeedBinding

class NewsFeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNewsFeedBinding =
            DataBindingUtil.setContentView(this@NewsFeedActivity, R.layout.activity_news_feed)

        binding.textOnScreen = "Hello"
        binding.textView.postDelayed({
            binding.textOnScreen = "Hello Again"
        }, 2_000)
    }
}