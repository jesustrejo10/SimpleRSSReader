package com.jesustrejo10.simplerssreader.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jesustrejo10.simplerssreader.R
import com.jesustrejo10.simplerssreader.data.local.datasource.MovieDao
import com.jesustrejo10.simplerssreader.data.local.entities.Movie

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
abstract class MainDataBase : RoomDatabase(){

    companion object {
        @Volatile
        private var INSTANCE: MainDataBase? = null

        fun getInstance(context: Context): MainDataBase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    context.resources.getString(R.string.database_name)
                ).fallbackToDestructiveMigration()
                    .build().also {
                        INSTANCE = it
                    }
            }
        }
    }

    abstract fun getMovieDao() : MovieDao
}