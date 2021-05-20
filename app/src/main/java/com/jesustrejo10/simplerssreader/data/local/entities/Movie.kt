package com.jesustrejo10.simplerssreader.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int?,
    @ColumnInfo(name = "title")
    var title: String?,
    @ColumnInfo(name = "release_date")
    var releaseDate: String?,
    @ColumnInfo(name = "backdrop_path")
    var backdropPath: String?,
    @ColumnInfo(name = "overview")
    var overview: String?,
    @ColumnInfo(name = "vote_average")
    var voteAverage: Double?,
    @ColumnInfo(name = "vote_count")
    var voteCount: Int?,
    @ColumnInfo(name = "adult")
    var adult: Boolean?
)
