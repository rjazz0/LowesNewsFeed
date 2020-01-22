package com.rjasso.lowesnewsfeed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rjasso.lowesnewsfeed.model.Repository

class NewsViewModelFactory(val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = NewsViewModel(repository) as T
}