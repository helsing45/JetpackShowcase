package com.ceos.jetpackshowcase.events.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.ceos.jetpackshowcase.core.local_storage.AppDatabase
import com.ceos.jetpackshowcase.events.data.local.entities.EventEntity
import com.ceos.jetpackshowcase.events.data.mappers.toEntity
import okio.IOException
import retrofit2.HttpException

@OptIn(ExperimentalPagingApi::class)
class EventRemoteMediator(
    private val localDataSource: AppDatabase,
    private val remoteDateSource: EventApi
) : RemoteMediator<Int, EventEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, EventEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.localDbId / state.config.pageSize) + 1
                    }
                }
            }
            remoteDateSource.getEvents(page = loadKey, pageSize = state.config.pageSize).let {
                if (it.events.isNullOrEmpty()) {
                    return MediatorResult.Success(endOfPaginationReached = true)
                }

                localDataSource.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        localDataSource.eventDao().clearEvents()
                    }
                    it.events.mapNotNull { eventDto -> eventDto?.toEntity() }.let { entities ->
                        localDataSource.eventDao().upsert(*entities.toTypedArray())
                    }

                    MediatorResult.Success((it.pagesize?.toInt() ?: 0) < state.config.pageSize)
                }
            }
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}