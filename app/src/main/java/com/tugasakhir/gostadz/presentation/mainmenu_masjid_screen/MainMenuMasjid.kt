package com.tugasakhir.gostadz.presentation.mainmenu_masjid_screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tugasakhir.gostadz.R
import com.tugasakhir.gostadz.presentation.route.Route
import com.tugasakhir.gostadz.ui.component.Banner
import com.tugasakhir.gostadz.ui.component.CardMenu
import com.tugasakhir.gostadz.ui.component.TopBar
import kotlinx.coroutines.launch

@Composable
fun MainMenuMasjid(navController: NavHostController) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TopBar(onClick = { navController.navigate(Route.LoginMasjid.route) })
        Column(
            modifier = Modifier
                .padding(24.dp)
        ) {
            Banner()
            Spacer(modifier = Modifier.padding(36.dp))
            CardMenu(onClick = {
                Log.i("XLog", "MainMenuMasjid: Clicked")
                scope.launch {
                    navController.navigate(Route.JadwalKegiatan.route)
                }
            }, id = R.drawable.list_alt, title = R.string.JadwalKegiatan, desc = R.string.Lihatjadwal)
            Spacer(modifier = Modifier.padding(16.dp))
            CardMenu(
                onClick = { /*TODO*/ },
                id = R.drawable.video,
                title = R.string.VideoCeramah,
                desc = R.string.TontonVideo
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainMenuMasjidPreview() {
//    MainMenuMasjid(navController)
}