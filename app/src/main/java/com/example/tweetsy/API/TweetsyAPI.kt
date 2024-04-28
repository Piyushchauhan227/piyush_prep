package com.example.tweetsy.API

import com.example.tweetsy.Models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyAPI {

    //@Headers("X-JSON-Path:quotes[?(@.author=='Rumi')]")

    @GET("v3/b/662bd7a6acd3cb34a83ea460?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path")cat:String):Response<List<TweetListItem>>
    //suspend fun getTweets(@Header("X-JSON-Path") author:String):Response<List<TweetListItem>>

    @GET("v3/b/662bd7a6acd3cb34a83ea460?meta=false")
    @Headers("X-JSON-Path:quotes..author")
    suspend fun getCategories():Response<List<String>>
}