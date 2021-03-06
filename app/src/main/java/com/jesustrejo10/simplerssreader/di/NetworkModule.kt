package com.jesustrejo10.simplerssreader.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jesustrejo10.simplerssreader.data.RestConstants
import com.jesustrejo10.simplerssreader.data.RestConstants.Companion.DEBUG
import com.jesustrejo10.simplerssreader.data.local.StaticValues
import com.jesustrejo10.simplerssreader.data.remote.EndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import kotlin.jvm.Throws

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl() = RestConstants.MOVIE_API_SERVER_BASE_URL

    @Provides
    fun provideGson() : Gson = GsonBuilder().setLenient().create()

    @Provides
    fun provideOkHttpClient() =

        if (DEBUG) { // debug ON
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder()
                .addInterceptor(logger)
                .readTimeout(100, TimeUnit.SECONDS)
                .connectTimeout(100, TimeUnit.SECONDS)
                .addNetworkInterceptor(StethoInterceptor())
                //.addNetworkInterceptor(getInterceptor())
                .build()
        } else // debug OFF
            OkHttpClient.Builder()
                .readTimeout(45, TimeUnit.SECONDS)
                .connectTimeout(45, TimeUnit.SECONDS)
                .addNetworkInterceptor(StethoInterceptor())
                //.addNetworkInterceptor(getInterceptor())
                .build()

    @Provides
    fun provideRssRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    @Provides
    fun provideApiDefinitionService(retrofit: Retrofit) =
        retrofit.create(EndPoints::class.java)

    private fun getInterceptor (): Interceptor {
        val authValue = "Bearer "+StaticValues.AUTHENTICATION
        return  object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val request: Request =
                    chain.request().newBuilder().addHeader("Authorization", authValue).build()
                return chain.proceed(request)
            }
        }
    }
}