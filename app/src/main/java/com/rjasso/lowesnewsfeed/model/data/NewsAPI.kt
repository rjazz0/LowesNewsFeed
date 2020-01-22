package com.rjasso.lowesnewsfeed.model.data

data class NewsAPI(
        val articles: List<Article>,
        val status: String,
        val totalResults: Int
)