package com.jesustrejo10.simplerssreader.data.local.datasource

import androidx.room.*
import com.jesustrejo10.simplerssreader.data.local.entities.Movie

@Dao
abstract class MovieDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg args: Movie)

    @Query("SELECT * FROM movies ORDER BY popularity DESC")
    abstract fun getMovies(): List<Movie>

    @Transaction
    @Query("SELECT * FROM movies WHERE id = :id")
    abstract fun getById(id: Int): Movie

}