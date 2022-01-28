package com.rachellimaa.news.data.repository

import android.content.Context
import com.rachellimaa.news.data.model.NewsResult
import com.rachellimaa.news.data.repository.api.INewsApiDataSource
import com.rachellimaa.news.data.repository.db.NewsDbDataSource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NewsRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val newsDbDataSource: NewsDbDataSource,
    private val INewsApiDataSource: INewsApiDataSource
) : INewsRepository {

    override suspend fun getNews(): NewsResult {
        return INewsApiDataSource.fetchNews()
    }
}