package com.example.tweetsy.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsy.Models.TweetListItem
import com.example.tweetsy.Repository.Repository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TweetViewModel() : ViewModel() {

    var repository:Repository = Repository()

    init {
         viewModelScope.launch {
             repository.getCategories()
         }
    }

    val category : StateFlow<List<String>>
        get() = repository.catState



}