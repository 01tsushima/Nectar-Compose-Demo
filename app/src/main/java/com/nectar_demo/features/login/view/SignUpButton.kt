package com.nectar_demo.features.login.view

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nectar_demo.R
import com.nectar_demo.ui.theme.oceanGreen
import com.nectar_demo.ui.theme.typography
import com.nectar_demo.ui.theme.white


@Composable
fun signUpButton(onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    Button(
        modifier = Modifier.padding(start = 8.dp),
        interactionSource = interactionSource,
        colors = ButtonDefaults.textButtonColors(backgroundColor = if (isPressed) oceanGreen else white),
        shape = RoundedCornerShape(4.dp),
        onClick = onClick,
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp, pressedElevation = 0.dp)
    ) {
        Text(
            text = stringResource(id = R.string.sign_up),
            style = typography.body2.copy(color = if (isPressed) white else oceanGreen)
        )
    }
}