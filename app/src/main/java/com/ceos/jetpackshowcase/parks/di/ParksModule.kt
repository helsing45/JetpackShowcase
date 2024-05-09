package com.ceos.jetpackshowcase.parks.di

import com.ceos.jetpackshowcase.BuildConfig
import com.ceos.jetpackshowcase.core.DispatcherProvider
import com.ceos.jetpackshowcase.parks.data.ParkRepositoryImpl
import com.ceos.jetpackshowcase.parks.data.local.ParkDao
import com.ceos.jetpackshowcase.parks.data.mappers.ParkMapper
import com.ceos.jetpackshowcase.parks.data.remote.ParksApi
import com.ceos.jetpackshowcase.parks.domain.repositories.ParkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

private val json = Json { ignoreUnknownKeys = true }

@InstallIn(SingletonComponent::class)
@Module
class ParksModule {


    @Provides
    @Singleton
    fun provideParksApi(): ParksApi {
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
            .create(ParksApi::class.java)
    }


    @Provides
    @Singleton
    fun provideParksRepository(
        dispatcherProvider: DispatcherProvider,
        dao: ParkDao,
        api: ParksApi
    ): ParkRepository =
        ParkRepositoryImpl(
            dispatcherProvider = dispatcherProvider,
            localDataSource = dao,
            remoteDataSource = api
        )

}