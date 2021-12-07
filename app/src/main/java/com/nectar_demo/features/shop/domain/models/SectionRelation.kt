package com.nectar_demo.features.shop.domain.models

import androidx.room.Embedded
import androidx.room.Relation

data class SectionRelation(
    @Embedded
    val owner: SectionModel,
    @Relation(parentColumn = "id", entityColumn = "ownerId")
    val subcategories: List<ProductModel>,
)