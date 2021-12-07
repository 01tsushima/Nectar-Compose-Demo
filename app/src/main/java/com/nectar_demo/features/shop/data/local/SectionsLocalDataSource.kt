package com.nectar_demo.features.shop.data.local

import com.nectar_demo.base.db.AppDataBase
import javax.inject.Inject

class SectionsLocalDataSource @Inject constructor(private val db: AppDataBase) {

    fun getCurrentDb() = db

    fun getSectionsDao() = getCurrentDb().daoSections()

}