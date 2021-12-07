package com.nectar_demo.features.shop.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nectar_demo.features.shop.data.local.SectionsLocalDataSource
import com.nectar_demo.features.shop.data.paging.SectionsRemoteMediator
import com.nectar_demo.features.shop.data.remote.SectionsRemoteDataSource
import com.nectar_demo.features.shop.domain.models.SectionRelation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SectionsRepository @Inject constructor(
    private val rds: SectionsRemoteDataSource,
    private val lds: SectionsLocalDataSource
) {

    @ExperimentalPagingApi
    fun getDataFromMediator(): Flow<PagingData<SectionRelation>> {
        val pagingSourceFactory = { lds.getSectionsDao().pagingSource() }
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                maxSize = PAGE_SIZE + (PAGE_SIZE * 2)
            ),
            remoteMediator = SectionsRemoteMediator(rds, lds.getCurrentDb()),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    companion object {
        private const val PAGE_SIZE = 5
    }
}