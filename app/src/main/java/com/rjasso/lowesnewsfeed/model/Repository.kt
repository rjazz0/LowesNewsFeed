package com.rjasso.lowesnewsfeed.model

import com.rjasso.lowesnewsfeed.model.data.NewsAPI
import retrofit2.Call

class Repository {
    fun getNews(search: String): Call<NewsAPI> {
        val map: HashMap<String,String> = HashMap()
        map.put("q",search)
        map.put("from","2019-12-22")
        map.put("sortBy","publishedAt")
        map.put("apiKey","7e931ba45c4c411d86a6983fe46c7761")
        return RetrofitClient.instance.getEverything(map)
    }
}