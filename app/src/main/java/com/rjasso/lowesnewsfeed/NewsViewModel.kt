package com.rjasso.lowesnewsfeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rjasso.lowesnewsfeed.model.Repository
import com.rjasso.lowesnewsfeed.model.data.NewsAPI
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class NewsViewModel(val repository: Repository) : ViewModel() {
    private val news: MutableLiveData<NewsAPI> by lazy {
        MutableLiveData<NewsAPI>().also {
            loadNews("Trump")
        }
    }

    fun getNews(): LiveData<NewsAPI> {
        return news
    }

    fun loadNews(search: String) {
        repository.getNews(search).enqueue(object: Callback, retrofit2.Callback<NewsAPI> {
            override fun onFailure(call: Call<NewsAPI>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<NewsAPI>, response: Response<NewsAPI>) {
                news.value = response.body()
            }
        })
    }
}
