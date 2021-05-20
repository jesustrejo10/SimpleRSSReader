package com.jesustrejo10.simplerssreader.di

import android.content.Context
import com.jesustrejo10.simplerssreader.data.local.MainDataBase
import com.jesustrejo10.simplerssreader.data.local.datasource.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Provides
    fun provideDataBase(@ApplicationContext context: Context) : MainDataBase {
        return MainDataBase.getInstance(context)
    }

    @Provides
    fun provideMovieDao(mainDataBase: MainDataBase) : MovieDao {
        return mainDataBase.getMovieDao()
    }

}