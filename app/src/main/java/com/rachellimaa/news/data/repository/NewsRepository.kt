package com.rachellimaa.news.data.repository

import android.content.Context
import com.rachellimaa.news.data.model.NewsResult
import com.rachellimaa.news.data.repository.api.INewsApiDataSource
import com.rachellimaa.news.data.repository.db.NewsDbDataSource

class NewsRepository(
    private val context: Context,
    private val newsDbDataSource: NewsDbDataSource,
    private val INewsApiDataSource: INewsApiDataSource
) : INewsRepository {

    override suspend fun getNews(): NewsResult {
        return INewsApiDataSource.fetchNews()
    }
}