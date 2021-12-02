package com.nectar_demo.acitivity.bottom.bar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.nectar_demo.R

sealed class NavigationItem(var route: String, @DrawableRes var icon: Int, @StringRes var title: Int) {
    object Shop : NavigationItem(Routes.Shop.name, R.drawable.ic_shop, R.string.shop)
    object Explore : NavigationItem(Routes.Explore.name, R.drawable.ic_search, R.string.explore)
    object Cart : NavigationItem(Routes.Cart.name, R.drawable.ic_cart, R.string.cart)
    object Favourite : NavigationItem(Routes.Favourites.name, R.drawable.ic_favorite, R.string.favourite)
    object Account : NavigationItem(Routes.Account.name, R.drawable.ic_account, R.string.account)
}
