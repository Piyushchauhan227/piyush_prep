package com.example.tweetsy.ViewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsy.Models.TweetListItem
import com.example.tweetsy.Repository.Repository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    var repository: Repository = Repository()

    init {
        viewModelScope.launch {
            val category = savedStateHandle?.get<String>("category") ?: "Rumi"
            repository.getTweets(category)
        }
    }

    val tweets : StateFlow<List<TweetListItem>>
        get() = repository.tweetState


}