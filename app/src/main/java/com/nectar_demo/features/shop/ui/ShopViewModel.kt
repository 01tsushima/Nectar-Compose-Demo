package com.nectar_demo.features.shop.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nectar_demo.features.shop.domain.models.SectionRelation
import com.nectar_demo.features.shop.domain.usecases.GetSectionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(
    private val useCase: GetSectionsUseCase
) : ViewModel() {

    @ExperimentalPagingApi
    val dataSource: Flow<PagingData<SectionRelation>> = useCase.invoke().cachedIn(viewModelScope)
}