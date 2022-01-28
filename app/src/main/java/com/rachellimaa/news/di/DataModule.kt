package com.rachellimaa.news.di

import com.rachellimaa.news.data.repository.INewsRepository
import com.rachellimaa.news.data.repository.NewsRepository
import com.rachellimaa.news.data.repository.NewsRetrofitApiDataSource
import com.rachellimaa.news.data.repository.api.INewsApiDataSource
import com.rachellimaa.news.data.repository.api.NewsFANApiDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Singleton
    @Binds
    abstract fun bindNewsRepository(
        newsRepository: NewsRepository
    ) : INewsRepository

    @Singleton
    @Binds
    abstract fun bindApiDatasource(
        // You can change for NewsFANApiDataSource for use Fast Android Networking Library
        newsRepository: NewsRetrofitApiDataSource
    ) : INewsApiDataSource
}