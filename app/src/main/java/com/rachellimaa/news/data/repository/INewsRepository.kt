package com.rachellimaa.news.data.repository

import com.rachellimaa.news.data.model.NewsResult

interface INewsRepository {
    suspend fun getNews(): NewsResult
}