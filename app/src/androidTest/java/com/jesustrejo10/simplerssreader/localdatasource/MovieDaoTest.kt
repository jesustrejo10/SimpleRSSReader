package com.jesustrejo10.simplerssreader.localdatasource

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jesustrejo10.simplerssreader.data.local.MainDataBase
import com.jesustrejo10.simplerssreader.data.local.datasource.MovieDao
import com.jesustrejo10.simplerssreader.localdatasource.stubs.MovieStub.Companion.movieA
import com.jesustrejo10.simplerssreader.localdatasource.stubs.MovieStub.Companion.movieB
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MovieDaoTest {


    private lateinit var movieDao: MovieDao
    private lateinit var db : MainDataBase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
                context, MainDataBase::class.java).build()
        movieDao = db.getMovieDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun shouldInsert() {
        val movieList = movieDao.getMovies()
        assert(movieList.isEmpty())
        movieDao.insert(movieA)
        val notificationList = movieDao.getMovies()
        assert(notificationList.isNotEmpty())
        assert(notificationList.firstOrNull() == movieA)
    }

    @Test
    fun shouldInsertMultipleViaVarArgs() {
        val movieList = movieDao.getMovies()
        assert(movieList.isEmpty())
        movieDao.insert(movieA,movieB)
        val notificationList = movieDao.getMovies()
        assert(notificationList.isNotEmpty())
        assert(notificationList.size == 2)
        assert(notificationList.contains(movieA))
        assert(notificationList.contains(movieB))
    }

    @Test
    fun shouldInsertMultipleViaList() {
        val movieList = movieDao.getMovies()
        assert(movieList.isEmpty())
        movieDao.insert(listOf(movieA,movieB))
        val notificationList = movieDao.getMovies()
        assert(notificationList.isNotEmpty())
        assert(notificationList.size == 2)
        assert(notificationList.contains(movieA))
        assert(notificationList.contains(movieB))
    }
}