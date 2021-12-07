package com.nectar_demo.features.shop.data.remote

import com.nectar_demo.features.shop.data.response.ProductsResponse
import com.nectar_demo.features.shop.data.response.SectionsResponse
import javax.inject.Inject

class SectionsRemoteDataSource @Inject constructor() {
    fun mockSections(): List<SectionsResponse> {
        return listOf(
            SectionsResponse(
                id = 1,
                name = "Exclusive Offers",
                products = mockExclusive()
            ),
            SectionsResponse(
                id = 2,
                name = "Best Sellings",
                products = mockBestSelling()
            )
        )
    }

    fun mockBestSelling(): List<ProductsResponse> {
        return listOf(
            ProductsResponse(
                id = 6,
                name = "Pepper",
                price = 4.99F,
                image = "https://images.ctfassets.net/6jpeaipefazr/1TOr5LlvLrYUqKCky4x7Xe/a93a8da6d9f1e52f2e8f5204c5374b56/co-op-red-peppers.jpg"
            ),
            ProductsResponse(
                id = 7,
                name = "Pepper",
                price = 4.99F,
                image = "https://images.ctfassets.net/6jpeaipefazr/1TOr5LlvLrYUqKCky4x7Xe/a93a8da6d9f1e52f2e8f5204c5374b56/co-op-red-peppers.jpg"
            ),
            ProductsResponse(
                id = 8,
                name = "Pepper",
                price = 4.99F,
                image = "https://images.ctfassets.net/6jpeaipefazr/1TOr5LlvLrYUqKCky4x7Xe/a93a8da6d9f1e52f2e8f5204c5374b56/co-op-red-peppers.jpg"
            ),
            ProductsResponse(
                id = 9,
                name = "Pepper",
                price = 4.99F,
                image = "https://images.ctfassets.net/6jpeaipefazr/1TOr5LlvLrYUqKCky4x7Xe/a93a8da6d9f1e52f2e8f5204c5374b56/co-op-red-peppers.jpg"
            )
        )
    }

    fun mockExclusive(): List<ProductsResponse> {
        return listOf(
            ProductsResponse(
                id = 1,
                name = "Bananas",
                price = 4.99F,
                image = "https://static.libertyprim.com/files/varietes/banane-cavendish-large.jpg?1569342222"
            ),
            ProductsResponse(
                id = 2,
                name = "Bananas",
                price = 4.99F,
                image = "https://static.libertyprim.com/files/varietes/banane-cavendish-large.jpg?1569342222"
            ),
            ProductsResponse(
                id = 3,
                name = "Bananas",
                price = 4.99F,
                image = "https://static.libertyprim.com/files/varietes/banane-cavendish-large.jpg?1569342222"
            ),
            ProductsResponse(
                id = 4,
                name = "Bananas",
                price = 4.99F,
                image = "https://static.libertyprim.com/files/varietes/banane-cavendish-large.jpg?1569342222"
            ),
            ProductsResponse(
                id = 5,
                name = "Bananas",
                price = 4.99F,
                image = "https://static.libertyprim.com/files/varietes/banane-cavendish-large.jpg?1569342222"
            ),
        )
    }
}