package com.example.deltanews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsFeedViewModel : ViewModel() {

    val repository = NewsFeedRepository()

    private val _newsFeedLiveData = MutableLiveData<List<NewFeedItem>>()
    val newsFeedLiveData: LiveData<List<NewFeedItem>> = _newsFeedLiveData

    fun fetchNewsFeed() {
        repository.fetchNewsFeed(_newsFeedLiveData)
    }
}