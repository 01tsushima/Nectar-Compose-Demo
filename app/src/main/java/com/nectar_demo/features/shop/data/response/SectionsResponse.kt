package com.nectar_demo.features.shop.data.response

data class SectionsResponse(
    val id: Int,
    val name: String,
    val products: List<ProductsResponse>
)