package com.example.deltanews.details

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.deltanews.R
import com.example.deltanews.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val ARG_URL = "_url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail)


        val client = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                binding.loadingProgressBar.hide()
            }
        }

        binding.webView.webViewClient = client
        binding.url = intent.getStringExtra(ARG_URL) ?: ""
    }
}