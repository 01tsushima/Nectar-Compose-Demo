package com.nectar_demo.base.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RemoteKeyModel @JvmOverloads constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val prev: Int?,
    val next: Int?
)