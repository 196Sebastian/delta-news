package com.example.deltanews.model

data class NewFeedItem(
    val id: String = "",
    val description: String = "",
    val title: String = "",
    val source: String = "",
    val published: String = "",
    val url: String = "",
    val image_url: String = "",
    val favorite: Boolean = false
)
