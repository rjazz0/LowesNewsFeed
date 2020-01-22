package com.rjasso.lowesnewsfeed.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val BASEURL: String = "https://newsapi.org/v2/"
    val instance by lazy {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASEURL)
                .build()
        retrofit.create(API::class.java)
    }
}