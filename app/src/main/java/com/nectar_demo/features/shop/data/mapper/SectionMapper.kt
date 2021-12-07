package com.nectar_demo.features.shop.data.mapper

import com.nectar_demo.features.shop.domain.models.ProductModel
import com.nectar_demo.features.shop.domain.models.SectionModel
import com.nectar_demo.features.shop.data.response.ProductsResponse
import com.nectar_demo.features.shop.data.response.SectionsResponse

fun List<SectionsResponse>.toSectionModel(): List<SectionModel> {
    return map {
        SectionModel(
            id = it.id,
            name = it.name,
            products = it.products.toProductModel()
        )
    }
}

fun List<ProductsResponse>.toProductModel(): List<ProductModel> {
    return map {
        ProductModel(
            id = it.id,
            name = it.name,
            image = it.image,
            price = it.price
        )
    }
}