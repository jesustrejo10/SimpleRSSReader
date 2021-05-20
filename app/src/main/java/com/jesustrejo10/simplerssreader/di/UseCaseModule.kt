package com.jesustrejo10.simplerssreader.di

import com.jesustrejo10.simplerssreader.data.local.datasource.MovieDao
import com.jesustrejo10.simplerssreader.data.remote.RemoteEndPoints
import com.jesustrejo10.simplerssreader.data.remote.datasource.AuthenticationRemoteDataSource
import com.jesustrejo10.simplerssreader.data.remote.datasource.RssRemoteDataSource
import com.jesustrejo10.simplerssreader.model.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideLoginUseCase(remoteDataSource: AuthenticationRemoteDataSource): LoginUseCase {
        return LoginUseCase(remoteDataSource)
    }

    @Provides
    fun provideSignUpUseCase(remoteDataSource: AuthenticationRemoteDataSource): SignUpUserUseCase {
        return SignUpUserUseCase(remoteDataSource)
    }

    @Provides
    fun provideSubscribeToFeedUseCase(remoteDataSource: RssRemoteDataSource) : SubscribeToFeedUseCase {
        return SubscribeToFeedUseCase(remoteDataSource)
    }

    @Provides
    fun provideGetArticlesForMyFeedUseCase(remoteDataSource: RssRemoteDataSource) : GetArticlesForMyFeedUseCase {
        return GetArticlesForMyFeedUseCase(remoteDataSource)
    }

    @Provides
    fun provideGetMovieListUseCase(localDataSource : MovieDao ) : GetMovieListUseCase {
        return GetMovieListUseCase(localDataSource)
    }

}