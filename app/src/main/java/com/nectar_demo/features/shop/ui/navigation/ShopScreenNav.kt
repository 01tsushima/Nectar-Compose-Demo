package com.nectar_demo.features.shop.ui.navigation

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nectar_demo.common.navigation.NavActions
import com.nectar_demo.features.shop.ui.ShopScreen
import com.nectar_demo.features.shop.ui.route.ShopScreenRoute

@ExperimentalComposeUiApi
@ExperimentalPagerApi
@ExperimentalPagingApi
fun NavGraphBuilder.shopScreenNav(
    navAction: NavActions,
){
    composable(ShopScreenRoute.route){
        ShopScreen(viewModel = hiltViewModel())
    }
}