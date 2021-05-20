package com.jesustrejo10.simplerssreader.di

import com.jesustrejo10.simplerssreader.data.remote.EndPoints
import com.jesustrejo10.simplerssreader.data.remote.datasource.AuthenticationRemoteDataSource
import com.jesustrejo10.simplerssreader.data.remote.datasource.MoviesRemoteDataSource
import com.jesustrejo10.simplerssreader.data.remote.datasource.RssRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Provides
    fun provideSessionRepository(endPoints: EndPoints): AuthenticationRemoteDataSource {
        return AuthenticationRemoteDataSource(endPoints)
    }

    @Provides
    fun provideRssRepository(endPoints: EndPoints): RssRemoteDataSource {
        return RssRemoteDataSource(endPoints)
    }

    @Provides
    fun provideMoviesRepository(endPoints: EndPoints) : MoviesRemoteDataSource {
        return MoviesRemoteDataSource(endPoints)
    }
}