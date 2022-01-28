package com.rachellimaa.news.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rachellimaa.news.data.model.Article
import com.rachellimaa.news.data.model.NewsResult
import com.rachellimaa.news.data.repository.INewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
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
                    println("ApiError")
                }
            }
            is NewsResult.UnknownError -> {
                println("UnknownError")
            }
        }
    }
}