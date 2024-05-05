package com.ceos.jetpackshowcase.core.di

import com.ceos.jetpackshowcase.core.di.navigation.Navigator
import com.ceos.jetpackshowcase.core.di.navigation.implementation.NavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CoreModule {

    @Singleton
    @Provides
    fun provideNavigator(): Navigator = NavigatorImpl()
}