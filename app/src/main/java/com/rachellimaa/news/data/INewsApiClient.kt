package com.rachellimaa.news.data

import com.haroldadmin.cnradapter.NetworkResponse
import com.rachellimaa.news.data.model.ErrorResponse
import com.rachellimaa.news.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface INewsApiClient {

    @GET("top-headlines?country=br")
    suspend fun getNews(
        @Query("category") category: String = "technology",
        @Query("apiKey") apiKey: String = NEWS_API_KEY
    ): NetworkResponse<NewsResponse, ErrorResponse>

    // Get Key in https://newsapi.org/
    companion object {
       private const val NEWS_API_KEY = ""
    }
}