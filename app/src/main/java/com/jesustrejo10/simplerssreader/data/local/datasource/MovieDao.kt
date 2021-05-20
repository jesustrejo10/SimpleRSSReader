package com.jesustrejo10.simplerssreader.data.local.datasource

import androidx.room.*
import com.jesustrejo10.simplerssreader.data.local.entities.Movie

@Dao
abstract class MovieDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg args: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(args: List<Movie>)

    @Query("SELECT * FROM movies")
    abstract fun getMovies(): List<Movie>

}