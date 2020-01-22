package com.rjasso.lowesnewsfeed.model

import com.rjasso.lowesnewsfeed.model.data.NewsAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface API {
    @GET("everything")
    fun getEverything(@QueryMap map: HashMap<String, String>): Call<NewsAPI>
}