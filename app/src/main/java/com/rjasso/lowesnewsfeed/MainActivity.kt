package com.rjasso.lowesnewsfeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rjasso.lowesnewsfeed.model.Repository
import com.rjasso.lowesnewsfeed.model.data.Article
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: NewsViewModel
    private var news: ArrayList<Article> = ArrayList()
    private val newsAdapter: NewsAdapter = NewsAdapter(news)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = newsAdapter
        viewModel = NewsViewModelFactory(Repository()).create(NewsViewModel::class.java)
        viewModel.getNews().observe(this, androidx.lifecycle.Observer {
            if (it != null) {
                newsAdapter.updateNews(it.articles)
            }
        })

    }


}
