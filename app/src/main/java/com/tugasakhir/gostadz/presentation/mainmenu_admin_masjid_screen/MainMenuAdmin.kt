package com.tugasakhir.gostadz.presentation.mainmenu_admin_masjid_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tugasakhir.gostadz.R
import com.tugasakhir.gostadz.presentation.route.Route
import com.tugasakhir.gostadz.ui.component.Banner
import com.tugasakhir.gostadz.ui.component.CardMenu
import com.tugasakhir.gostadz.ui.component.TopBar

@Composable
fun MainMenuAdmin(navController: NavHostController) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
    ){
        TopBar(onClick = { navController.navigate(Route.LoginMasjid.route)})
        Column (
            modifier = Modifier
                .padding(24.dp)
        ){
            Banner()
            Spacer(modifier = Modifier.padding(36.dp))
            CardMenu(onClick = { /*TODO*/ }, id = R.drawable.list_alt, title = R.string.Managejadwal, desc = R.string.AturJadwal)
            Spacer(modifier = Modifier.padding(24.dp))
            CardMenu(onClick = { /*TODO*/ }, id = R.drawable.video, title = R.string.ManageVideo, desc = R.string.Managevideountukjamaah)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainMenuAdminPreview() {
//    MainMenuAdmin(navController)
}