package com.rachellimaa.news.data.repository.api

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.rachellimaa.news.data.model.NewsResponse
import com.rachellimaa.news.data.model.NewsResult
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

// Using fast android network

class NewsFANApiDataSource @Inject constructor(): INewsApiDataSource {

    override suspend fun fetchNews(): NewsResult {
        return suspendCoroutine { continuation ->
            AndroidNetworking.get("https://newsapi.org/v2/top-headlines?country=br")
                .addQueryParameter("category", "technology")
                .addQueryParameter("apiKey", NEWS_API_KEY)
                .build()
                .getAsObject(
                    NewsResponse::class.java,
                    object : ParsedRequestListener<NewsResponse> {
                        override fun onResponse(response: NewsResponse?) {
                            response?.let {
                                continuation.resumeWith(Result.success(NewsResult.Success(it.articles)))
                            }
                        }

                        override fun onError(anError: ANError?) {
                            continuation.resumeWith(Result.failure(Throwable("Unknown error")))
                        }
                    })
        }
    }

    // Get Key in https://newsapi.org/
    companion object {
        private const val NEWS_API_KEY = ""
    }
}