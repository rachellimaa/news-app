package com.rachellimaa.news.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rachellimaa.news.data.model.Article
import com.rachellimaa.news.data.model.NewsResult
import com.rachellimaa.news.data.repository.INewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsRepository: INewsRepository
) : ViewModel() {

    private val _articlesEvent = MutableLiveData<List<Article>>()
    val articlesEvent: LiveData<List<Article>>
        get() = _articlesEvent

    fun getNews() = viewModelScope.launch {
        when (val newsResult = newsRepository.getNews()) {
            is NewsResult.Success -> {
                _articlesEvent.value = newsResult.articles
            }
            is NewsResult.ApiError -> {
                if (newsResult.code == 401) {
                    // Show screen error
                }
            }
            is NewsResult.UnknownError -> {
                // Show toast
            }
        }
    }
}