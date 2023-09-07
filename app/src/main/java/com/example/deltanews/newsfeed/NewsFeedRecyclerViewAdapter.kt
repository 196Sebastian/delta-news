package com.example.deltanews.newsfeed

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deltanews.R
import com.example.deltanews.databinding.ViewHolderNewsFeedItemBinding
import com.example.deltanews.model.NewFeedItem

class NewsFeedRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val newsFeedItem = mutableListOf<NewFeedItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsFeedItemViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return newsFeedItem.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewsFeedItemViewHolder).onBind(newsFeedItem[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewsFeedItem(newFeedItem: List<NewFeedItem>?) {
        this.newsFeedItem.clear()
        this.newsFeedItem.addAll(newFeedItem ?: emptyList())
        notifyDataSetChanged()
    }

    inner class NewsFeedItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_news_feed_item, parent, false)
    ) {
        private val binding = ViewHolderNewsFeedItemBinding.bind(itemView)

        fun onBind(newFeedItem: NewFeedItem) {
            binding.title = newFeedItem.title
            binding.description = newFeedItem.description
            binding.source = newFeedItem.source
            binding.published = newFeedItem.published
            binding.imageUrl = newFeedItem.image_url
        }
    }
}