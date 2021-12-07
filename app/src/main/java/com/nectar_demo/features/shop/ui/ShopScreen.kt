package com.nectar_demo.features.shop.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nectar_demo.features.shop.domain.models.SectionRelation
import com.nectar_demo.ui.theme.white

@ExperimentalPagingApi
@ExperimentalPagerApi
@ExperimentalComposeUiApi
@Composable
fun ShopScreen(viewModel: ShopViewModel) {

    val systemUiController = rememberSystemUiController()
    val sections: LazyPagingItems<SectionRelation> = viewModel.dataSource.collectAsLazyPagingItems()
    systemUiController.setStatusBarColor(white)

    LazyColumn {
        items(sections) { section ->
            section?.owner?.name?.let { Text(it) }
        }
    }
}