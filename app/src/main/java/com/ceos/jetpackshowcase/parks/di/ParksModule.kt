package com.ceos.jetpackshowcase.parks.di

import com.ceos.jetpackshowcase.core.DispatcherProvider
import com.ceos.jetpackshowcase.core.logger.Logger
import com.ceos.jetpackshowcase.parks.data.ParkRepositoryImpl
import com.ceos.jetpackshowcase.parks.data.local.ParkDao
import com.ceos.jetpackshowcase.parks.data.remote.ParksApi
import com.ceos.jetpackshowcase.parks.domain.repositories.ParkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class ParksModule {

    @Provides
    @Singleton
    fun provideParksApi(retrofit: Retrofit) = retrofit
        .create(ParksApi::class.java)


    @Provides
    @Singleton
    fun provideParksRepository(
        logger: Logger,
        dispatcherProvider: DispatcherProvider,
        dao: ParkDao,
        api: ParksApi
    ): ParkRepository =
        ParkRepositoryImpl(
            logger = logger,
            dispatcherProvider = dispatcherProvider,
            localDataSource = dao,
            remoteDataSource = api
        )

}