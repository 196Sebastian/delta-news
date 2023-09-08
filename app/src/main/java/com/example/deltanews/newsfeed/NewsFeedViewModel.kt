package com.example.deltanews.newsfeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deltanews.model.NewFeedItem

class NewsFeedViewModel : ViewModel() {

    val repository = NewsFeedRepository()

    private val _newsFeedLiveData = MutableLiveData<List<NewFeedItem>>()
    val newsFeedLiveData: LiveData<List<NewFeedItem>> = _newsFeedLiveData

    fun fetchNewsFeed() {
        repository.fetchNewsFeed(_newsFeedLiveData)
    }

    fun updateFavoriteStatus(id: String, isFavorite: Boolean) {
        repository.updateFavoriteStatus(id, isFavorite)
    }
}