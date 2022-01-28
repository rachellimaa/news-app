package com.rachellimaa.news.data.repository

import com.haroldadmin.cnradapter.NetworkResponse
import com.rachellimaa.news.data.NewsApiClient
import com.rachellimaa.news.data.model.NewsResult
import com.rachellimaa.news.data.repository.api.INewsApiDataSource

class NewsRetrofitApiDataSource(
    private val newsApiClient: NewsApiClient
) : INewsApiDataSource {

    override suspend fun fetchNews(): NewsResult  {
        return when (val newsResponse = newsApiClient.getNews()) {
            is NetworkResponse.Success -> {
                val articles = newsResponse.body.articles
                NewsResult.Success(articles)
            }
            is NetworkResponse.ServerError -> {
                NewsResult.ApiError(newsResponse.code, newsResponse.body?.message)
            }
            else -> NewsResult.UnknownError("Unknown error")
        }
    }
}