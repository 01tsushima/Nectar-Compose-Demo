package com.nectar_demo.base.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nectar_demo.features.shop.data.local.DaoSections
import com.nectar_demo.features.shop.domain.models.ProductModel
import com.nectar_demo.features.shop.domain.models.SectionModel

@Database(
    version = 1,
    exportSchema = false,
    entities = [
        SectionModel::class,
        RemoteKeyModel::class,
        ProductModel::class
    ]
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun daoSections(): DaoSections
}