package com.nectar_demo.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val typography = Typography(
    h1 = TextStyle(
        color = black,
        fontSize = 26.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = fonts
    ),
    h2 = TextStyle(
        color = midnightExpress,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = fonts
    ),
    button = TextStyle(
        color = white,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = fonts
    ),
    body1 = TextStyle(
        color = grey,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = fonts
    ),
    body2 = TextStyle(
        color = black,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = fonts
    ),
    caption = TextStyle(
        color = white,
        fontSize = 48.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = fonts
    )
)