package com.ceos.jetpackshowcase.events.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.ceos.jetpackshowcase.core.local_storage.AppDatabase
import com.ceos.jetpackshowcase.events.data.remote.EventApi
import com.ceos.jetpackshowcase.events.data.remote.EventRemoteMediator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class EventModule {

    @Singleton
    @Provides
    fun provideEventApi(retrofit: Retrofit) = retrofit.create(EventApi::class.java)

    @OptIn(ExperimentalPagingApi::class)
    @Singleton
    @Provides
    fun provideEventPager(database: AppDatabase, eventApi: EventApi) = Pager(
        config = PagingConfig(pageSize = 10),
        remoteMediator = EventRemoteMediator(database, eventApi),
        pagingSourceFactory = { database.eventDao().pagingSource() }
    )

}