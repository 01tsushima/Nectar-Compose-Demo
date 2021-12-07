package com.nectar_demo.features.shop.domain.models

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@Entity
@TypeConverters(ProductConverter::class)
data class SectionModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String = "",
    @Ignore
    val products: List<ProductModel> = emptyList()
) {
    constructor(id: Int, name: String) : this(id, name, listOf())
}

class ProductConverter {
    val gson = Gson()

    @TypeConverter
    fun toProducts(value: String): List<ProductModel>? {
        if (value == null) {
            return null
        }

        val type: Type = object : TypeToken<List<ProductModel?>?>() {}.getType()
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromProducts(value: List<ProductModel>) = gson.toJson(value)
}