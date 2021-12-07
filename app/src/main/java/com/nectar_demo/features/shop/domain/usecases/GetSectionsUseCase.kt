package com.nectar_demo.features.shop.domain.usecases

import androidx.paging.ExperimentalPagingApi
import com.nectar_demo.features.shop.data.repository.SectionsRepository
import javax.inject.Inject

class GetSectionsUseCase @Inject constructor(
    private val repository: SectionsRepository
) {

    @ExperimentalPagingApi
    operator fun invoke() = repository.getDataFromMediator()
}