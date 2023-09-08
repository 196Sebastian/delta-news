package com.example.deltanews.newsfeed

import androidx.lifecycle.MutableLiveData
import com.example.deltanews.model.NewFeedItem
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class NewsFeedRepository {

    val dataBase = Firebase.database
    val newsFeedReference = dataBase.getReference("news_feed")

    fun fetchNewsFeed(liveData: MutableLiveData<List<NewFeedItem>>) {
        newsFeedReference
            .orderByChild("_rank")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val newsFeedItem: List<NewFeedItem> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(NewFeedItem::class.java)!!
                            .copy(id = dataSnapshot.key!!)
                    }

                    liveData.postValue(newsFeedItem)
                }

                override fun onCancelled(error: DatabaseError) {
                    // Nothing to do
                }

            })
    }

    fun updateFavoriteStatus(id: String, isFavorite: Boolean) {
        newsFeedReference.child(id).child("favorite").setValue(isFavorite)
    }
}