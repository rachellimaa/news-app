package com.rachellimaa.news.data.repository.api

import com.rachellimaa.news.data.model.NewsResult

interface INewsApiDataSource {

    suspend fun fetchNews(): NewsResult
}