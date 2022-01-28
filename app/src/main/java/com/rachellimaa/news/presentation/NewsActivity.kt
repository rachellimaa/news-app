package com.rachellimaa.news.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rachellimaa.news.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}