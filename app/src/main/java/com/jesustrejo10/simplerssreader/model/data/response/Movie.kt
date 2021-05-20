package com.jesustrejo10.simplerssreader.model.data.response

data class Movie (
    val adult: Boolean,
    val backdrop_path: String,
    val id: Int,
    val overview: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
)