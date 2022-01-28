package com.rachellimaa.news

import android.app.Application
import com.androidnetworking.AndroidNetworking

class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        AndroidNetworking.initialize(applicationContext)
    }
}