package com.nectar_demo.features.shop.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nectar_demo.base.db.RemoteKeyModel
import com.nectar_demo.features.shop.domain.models.SectionModel
import com.nectar_demo.features.shop.domain.models.SectionRelation

@Dao
interface DaoSections {

    @Query("Select * from SectionModel")
    fun pagingSource():PagingSource<Int,SectionRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllKeys(list: List<RemoteKeyModel>)

    @Query("Delete from SectionModel")
    suspend fun deleteAllSections()

    @Query("Delete from RemoteKeyModel")
    suspend fun deleteAllRemoteKeys()

    @Query("SELECT * FROM RemoteKeyModel WHERE id = :id")
    suspend fun remoteKeyMessageId(id: Int): RemoteKeyModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSections(list: List<SectionModel>)
}