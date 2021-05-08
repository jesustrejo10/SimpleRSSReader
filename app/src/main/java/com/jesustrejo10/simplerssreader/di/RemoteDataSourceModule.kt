package com.jesustrejo10.simplerssreader.di

import com.jesustrejo10.simplerssreader.data.remote.RemoteEndPoints
import com.jesustrejo10.simplerssreader.data.remote.datasource.AuthenticationRemoteDataSource
import com.jesustrejo10.simplerssreader.data.remote.repository.AuthenticationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Provides
    fun provideSessionRepository(remoteEndPoints: RemoteEndPoints): AuthenticationRemoteDataSource {
        return AuthenticationRemoteDataSource(remoteEndPoints)
    }
}