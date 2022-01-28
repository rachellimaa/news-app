package com.rachellimaa.news.data.model

import com.squareup.moshi.Json

data class ErrorResponse(
    @field:Json(name = "message") val message: String
)