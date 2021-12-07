package com.nectar_demo.features.shop.domain.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class ProductModel(
    @PrimaryKey val id: Int = 0,
    val ownerId:Int = 0,
    val price: Float = 0.0F,
    val image: String = "",
    val name: String = ""
):Parcelable