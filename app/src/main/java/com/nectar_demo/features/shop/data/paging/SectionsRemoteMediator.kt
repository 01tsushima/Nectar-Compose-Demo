package com.nectar_demo.features.shop.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.nectar_demo.base.db.AppDataBase
import com.nectar_demo.base.db.RemoteKeyModel
import com.nectar_demo.features.shop.data.mapper.toSectionModel
import com.nectar_demo.features.shop.data.remote.SectionsRemoteDataSource
import com.nectar_demo.features.shop.domain.models.SectionRelation
import java.io.IOException

@ExperimentalPagingApi
class SectionsRemoteMediator(
    private val rds: SectionsRemoteDataSource,
    private val db: AppDataBase
) : RemoteMediator<Int, SectionRelation>() {


    override suspend fun load(
        loadType: LoadType, state: PagingState<Int, SectionRelation>
    ): MediatorResult {
        val page = when (val pageKeyData = getKeyPageData(loadType, state)) {
            is MediatorResult.Success -> {
                return pageKeyData
            }
            else -> {
                pageKeyData as Int
            }
        }

        try {
            val response =
                rds.mockSections()
            val isEndOfList = response.isEmpty()
            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    db.daoSections().deleteAllSections()
                    db.daoSections().deleteAllRemoteKeys()
                }
                val prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1
                val nextKey = if (isEndOfList) null else page + 1
                val keys = response.map {
                    RemoteKeyModel(id = it.id, prev = prevKey, next = nextKey)
                }
                db.daoSections().insertAllKeys(keys)
                db.daoSections().insertSections(response.toSectionModel())
            }
            return MediatorResult.Success(endOfPaginationReached = isEndOfList)

        } catch (exception: IOException) {
            return MediatorResult.Error(exception)
        } catch (exception: Exception) {
            return MediatorResult.Error(exception)
        }
    }

    private suspend fun getKeyPageData(
        loadType: LoadType,
        state: PagingState<Int, SectionRelation>
    ): Any {
        return when (loadType) {
            LoadType.REFRESH -> {
                STARTING_PAGE_INDEX
            }
            LoadType.APPEND -> {
                val remoteKeys = getLastRemoteKey(state)
                val nextKey = remoteKeys?.next
                return nextKey ?: MediatorResult.Success(endOfPaginationReached = false)
            }
            LoadType.PREPEND -> {
                val remoteKeys = getFirstRemoteKey(state)
                val prevKey = remoteKeys?.prev ?: return MediatorResult.Success(
                    endOfPaginationReached = false
                )
                prevKey
            }
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, SectionRelation>): RemoteKeyModel? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.owner?.id?.let { repoId ->
                db.daoSections().remoteKeyMessageId(repoId)
            }
        }
    }

    private suspend fun getLastRemoteKey(state: PagingState<Int, SectionRelation>): RemoteKeyModel? {
        return state.pages
            .lastOrNull { it.data.isNotEmpty() }
            ?.data?.lastOrNull()
            ?.let { msg -> db.daoSections().remoteKeyMessageId(msg.owner.id) }
    }

    private suspend fun getFirstRemoteKey(state: PagingState<Int, SectionRelation>): RemoteKeyModel? {
        return state.pages
            .firstOrNull { it.data.isNotEmpty() }
            ?.data?.firstOrNull()
            ?.let { msg -> db.daoSections().remoteKeyMessageId(msg.owner.id) }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}