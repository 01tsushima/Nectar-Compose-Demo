package com.nectar_demo.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val oceanGreen = Color(0xFF53B175)
val background = Color(0xFFFCFCFC)
val lavenderBlush = Color(0xFFFFF9FF)
val white = Color(0xFFFFFFFF)
val background70 = Color(0xB2FCFCFC)
val cornflowerBlue = Color(0xFF5383EC)
val mariner = Color(0xFF4A66AC)
val grey = Color(0xFF7C7C7C)
val midnightExpress = Color(0xFF181725)
val darkGray = Color(0xFFB1B1B1)
val gainsboro = Color(0xFFE2E2E2)
val lilyWhite = Color(0xFFF2F3F2)

fun appColor() = Colors(
    primary = background,
    primaryVariant = white,
    secondary = oceanGreen,
    secondaryVariant = lavenderBlush,
    background = background,
    surface = white,
    error = darkGray,
    onPrimary = gainsboro,
    onSecondary = lilyWhite,
    onBackground = background,
    onSurface = grey,
    onError = midnightExpress,
    isLight = true,
)
