package com.tugasakhir.gostadz.presentation.getstarted_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tugasakhir.gostadz.R
import com.tugasakhir.gostadz.presentation.route.Route
import com.tugasakhir.gostadz.ui.component.GButton
import com.tugasakhir.gostadz.ui.component.PopMedium24
import com.tugasakhir.gostadz.ui.component.PopSemi48
import kotlinx.coroutines.launch

@Composable
fun GetStartedScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    val scope = rememberCoroutineScope()
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.getstarted),
            contentDescription = "background_image",
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(top = 180.dp, start = 48.dp)
        ) {
            PopMedium24(text = "Welcome", color = Color.White)
            PopSemi48(text = "GoStadz", color = Color.White)
        }
        Column(modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 24.dp),
            verticalArrangement = Arrangement.Bottom,) {
            GButton(text = "Get Started", onClick = {
                scope.launch {
                    navController.navigate(Route.Home.route)
                }
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetStartedScreenPreview() {

}