package com.rachellimaa.news.data.repository

import com.haroldadmin.cnradapter.NetworkResponse
import com.rachellimaa.news.data.INewsApiClient
import com.rachellimaa.news.data.model.NewsResult
import com.rachellimaa.news.data.repository.api.INewsApiDataSource
import javax.inject.Inject

class NewsRetrofitApiDataSource @Inject constructor(
    private val INewsApiClient: INewsApiClient
) : INewsApiDataSource {

    override suspend fun fetchNews(): NewsResult  {
        return when (val newsResponse = INewsApiClient.getNews()) {
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