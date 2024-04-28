package com.example.tweetsy.Screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsy.ViewModel.DetailViewModel


@Composable
fun DetailScreen(){

    val detailViewModel:DetailViewModel = viewModel()
    val tweets = detailViewModel.tweets.collectAsState()

    LazyColumn(content = {
        items(tweets.value){
            TweetListItem(tweet = it.quote)
        }
    })
}


@Composable
fun TweetListItem(tweet:String){
    Card (modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(),
        border = BorderStroke(1.dp, Color(0xFFEEEEE))
    ) {
        Text(text = tweet,
            modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.bodyMedium)
    }
}