package com.rachellimaa.news.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory

object WebApiAccess {
    val newsApi : NewsApiClient by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .build()

        return@lazy retrofit.create(NewsApiClient::class.java)
    }
}