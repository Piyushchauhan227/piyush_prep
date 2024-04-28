package com.example.tweetsy.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tweetsy.API.RetrofitInstance
import com.example.tweetsy.API.TweetsyAPI
import com.example.tweetsy.Models.TweetListItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Repository () {

    var api = RetrofitInstance.api

    private val categories = MutableStateFlow<List<String>>(emptyList())
    val catState : StateFlow<List<String>>
        get() = categories

    private val tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweetState : StateFlow<List<TweetListItem>>
        get() = tweets


    suspend fun getCategories(){
        val response = api.getCategories()
        if(response.isSuccessful && response.body()!= null){
            categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(cat:String){
        val response = api.getTweets("quotes[?(@.author=='$cat')]")
        if(response.isSuccessful && response.body()!= null){
            tweets.emit(response.body()!!)
            Log.d("inserthan",response.body().toString())
        }
    }


}