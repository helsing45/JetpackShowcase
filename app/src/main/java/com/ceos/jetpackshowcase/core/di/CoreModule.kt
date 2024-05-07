package com.ceos.jetpackshowcase.core.di

import com.ceos.jetpackshowcase.core.DispatcherProvider
import com.ceos.jetpackshowcase.core.navigation.Navigator
import com.ceos.jetpackshowcase.core.navigation.implementation.NavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CoreModule {

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
}