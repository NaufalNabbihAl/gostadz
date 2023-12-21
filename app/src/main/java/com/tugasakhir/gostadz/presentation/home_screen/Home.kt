package com.tugasakhir.gostadz.presentation.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tugasakhir.gostadz.R
import com.tugasakhir.gostadz.data.model.ItemIcon
import com.tugasakhir.gostadz.presentation.route.Route
import com.tugasakhir.gostadz.ui.component.CardIcon
import com.tugasakhir.gostadz.ui.component.PopBold13
import com.tugasakhir.gostadz.ui.component.PopReg12
import com.tugasakhir.gostadz.ui.component.PopSem32
import com.tugasakhir.gostadz.ui.theme.Black
import com.tugasakhir.gostadz.ui.theme.Primary
import kotlinx.coroutines.launch

@Composable
fun Home(navController: NavHostController) {
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(8.dp)) {
        Column(
            modifier = Modifier
                .padding( top = 126.dp),
        ) {
            PopSem32(text = "Pilih Jenis", color = Black)
            PopSem32(text = "Kegiatan", color = Primary)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            CardIcon(ItemIcon(R.drawable.tpq, R.string.TPQ), onClick = {
                scope.launch {
                    navController.navigate(Route.LoginTpq.route)
                }
            })
            CardIcon(ItemIcon(R.drawable.masjid, R.string.MASJID), onClick = {
                scope.launch {
                    navController.navigate(Route.MainMenuMasjid.route)
                }
            })
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            CardIcon(ItemIcon(R.drawable.infaq, R.string.INFAQ), onClick = {
                scope.launch {
                    navController.navigate(Route.Infaq.route)
                }
            })
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 55.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PopBold13(text = stringResource(id = R.string.About), color = Black)
            PopReg12(text = stringResource(id = R.string.Islami), color = Black)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
//    Home(navController)
}
