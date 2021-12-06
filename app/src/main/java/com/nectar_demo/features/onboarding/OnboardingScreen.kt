package com.nectar_demo.features.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nectar_demo.R
import com.nectar_demo.ui.theme.background70
import com.nectar_demo.ui.theme.oceanGreen
import com.nectar_demo.ui.theme.typography
import com.nectar_demo.ui.theme.white

@Composable
fun OnboardingScreen(onEvent:()->Unit) {
    val systemUiController = rememberSystemUiController()
    systemUiController.isStatusBarVisible = false

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (background, title, subtitle, button, carrot_iv) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.background_onboarding),
            contentDescription = "background",
            modifier = Modifier.constrainAs(background) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            contentScale = ContentScale.Crop
        )
        Button(
            onClick = { onEvent()},
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = oceanGreen
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(button) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .padding(start = 16.dp, end = 16.dp, bottom = 90.dp)
        ) {
            Text(
                text = stringResource(id = R.string.get_started),
                style = typography.button,
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
        Text(
            text = stringResource(id = R.string.get_groceries),
            style = typography.body1.copy(color = background70),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(subtitle) {
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    bottom.linkTo(button.top, margin = 40.dp)
                }
        )
        Text(
            text = stringResource(id = R.string.welcome),
            style = typography.caption,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(title) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(subtitle.top)
                }
        )
        Image(
            painter = painterResource(id = R.drawable.ic_carrot),
            contentDescription = "carrot",
            colorFilter = ColorFilter.tint(white, BlendMode.SrcAtop),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(carrot_iv) {
                    bottom.linkTo(title.top, margin = 36.dp)
                }
        )
    }
}