package com.ceos.jetpackshowcase.core.di

import com.ceos.jetpackshowcase.BuildConfig
import com.ceos.jetpackshowcase.core.DispatcherProvider
import com.ceos.jetpackshowcase.core.logger.Logger
import com.ceos.jetpackshowcase.core.logger.LoggerImpl
import com.ceos.jetpackshowcase.core.navigation.Navigator
import com.ceos.jetpackshowcase.core.navigation.implementation.NavigatorImpl
import com.ceos.jetpackshowcase.core.retrofit.interceptors.headerInterceptorWith
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton


private val json = Json { ignoreUnknownKeys = true }
@InstallIn(SingletonComponent::class)
@Module
class CoreModule {

    @Singleton
    @Provides
    fun provideLogger(): Logger = LoggerImpl()

    @Singleton
    @Provides
    fun provideNavigator(): Navigator = NavigatorImpl()

    @Singleton
    @Provides
    fun provideDispatcherProvider(): DispatcherProvider {
        return object : DispatcherProvider {
            override fun main(): CoroutineDispatcher = Dispatchers.Main
            override fun default(): CoroutineDispatcher = Dispatchers.Default
            override fun io(): CoroutineDispatcher = Dispatchers.IO
            override fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined
        }
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(): Retrofit {
        val client = OkHttpClient()
            .newBuilder()
            .addInterceptor(headerInterceptorWith("X-Api-Key" to BuildConfig.NPS_API_KEY))
            .build()

        return Retrofit
            .Builder()
            .client(client)
            .baseUrl("https://developer.nps.gov/api/v1/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
}