package com.tugasakhir.gostadz.presentation.jadwal_kegiatan_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tugasakhir.gostadz.ui.component.ListItemJadwal
import com.tugasakhir.gostadz.ui.component.PopSemi14
import com.tugasakhir.gostadz.ui.component.poppins
import com.tugasakhir.gostadz.ui.theme.Black
import com.tugasakhir.gostadz.ui.theme.Primary
import org.koin.androidx.compose.getViewModel


@Composable
fun JadwalKegiatan(
    viewModel: JadwalKegiatanViewModel = getViewModel(),
    navController: NavHostController
) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            PopSemi14(text = "Jadwal Kegiatan", Primary)
        }
        Spacer(modifier = Modifier.padding(top = 24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.padding(start = 24.dp))
            Text(
                text = "Tanggal",
                fontFamily = poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Black
            )
            Spacer(modifier = Modifier.padding(start = 40.dp))
            Text(
                text = "Jam",
                fontFamily = poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Black
            )
            Spacer(modifier = Modifier.padding(start = 52.dp))
            Text(
                text = "Kegiatan",
                fontFamily = poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Black
            )
            Spacer(modifier = Modifier.padding(start = 24.dp))
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.FilterList,
                    contentDescription = null,
                    tint = Primary
                )
            }
        }
        LazyColumn {
            items(state.jadwal ?: emptyList()) {jadwal ->
                ListItemJadwal(
                    tanggal = jadwal.tanggal,
                    jam = jadwal.jam,
                    kegiatan = jadwal.kegiatan
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JadwalKegiatanPreview() {

}