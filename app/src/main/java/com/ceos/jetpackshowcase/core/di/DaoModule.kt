package com.ceos.jetpackshowcase.core.di

import android.content.Context
import androidx.room.Room
import com.ceos.jetpackshowcase.core.local_storage.AppDatabase
import com.ceos.jetpackshowcase.parks.data.local.ParkDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DaoModule {


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "jetpack_showcase_database"
        ).build()

    @Provides
    fun provideParkDao(db: AppDatabase):ParkDao = db.parkDao()

}