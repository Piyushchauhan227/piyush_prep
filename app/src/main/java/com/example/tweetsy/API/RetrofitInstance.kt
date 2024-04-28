package com.example.tweetsy.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api:TweetsyAPI by lazy {
        Retrofit.Builder().baseUrl("https://api.jsonbin.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TweetsyAPI::class.java)
    }
}