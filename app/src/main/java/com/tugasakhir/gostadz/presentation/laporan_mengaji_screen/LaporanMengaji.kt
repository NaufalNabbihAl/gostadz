package com.tugasakhir.gostadz.presentation.laporan_mengaji_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.tugasakhir.gostadz.R
import com.tugasakhir.gostadz.ui.component.*
import com.tugasakhir.gostadz.ui.theme.Black
import com.tugasakhir.gostadz.ui.theme.Primary
import org.koin.androidx.compose.getViewModel

@Composable
fun LaporanMengaji(viewModel: LaporanMengajiViewModel = getViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val searchValue = viewModel.searchValue.collectAsState().value
        val name by remember { mutableStateOf("") }
        val surah by remember { mutableStateOf("") }
        val ayat by remember { mutableStateOf("") }

        val state = viewModel.state.value
        Spacer(modifier = Modifier.padding(top = 24.dp))
        PopSem32("Laporan", Black, Modifier.padding(start = 8.dp))
        PopSem32("MENGAJI", Primary, Modifier.padding(start = 48.dp))
        PopSem32("SANTRI", Primary, Modifier.padding(start = 48.dp))
        Spacer(modifier = Modifier.padding(top = 16.dp))
        TextFieldSearch(
            modifier = Modifier,
            value = searchValue,
            onChange = {
                viewModel.search(it)
            },
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.padding(start = 24.dp))
            Text(
                text = "Nama",
                fontFamily = poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Black
            )
            Spacer(modifier = Modifier.padding(start = 84.dp))
            Text(
                text = "Surah",
                fontFamily = poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Black
            )
            Spacer(modifier = Modifier.padding(start = 66.dp))
            Text(
                text = "Ayat",
                fontFamily = poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Black
            )
        }
        LazyColumn {
            items(state.laporans ?: emptyList(), key = { it.id }) { santri ->
                ListLaporanMengaji(
                    nama = santri.full_name,
                    surah = santri.surah,
                    ayat = santri.ayat,
                    id = santri.id,
                    onEdit = { id ->
                        viewModel.onEvent(LaporanMengajiEvent.ChangeDialog(true))
                        viewModel.onEvent(LaporanMengajiEvent.ChangeSelectedId(id))
                    }
                )
            }
        }


        if (viewModel.state.value.showEditDialog) {
            Dialog(onDismissRequest = {
                viewModel.onEvent(LaporanMengajiEvent.ChangeDialog(false))
            }) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .border(1.dp, Color.Black)
                ) {
                    Column (
                        modifier = Modifier
                        .background(Color.White)
                            .padding(16.dp)
                    ){
                        BackButton(
                            onClick = {},
                            "Laporan Mengaji"
                        )
                        Spacer(modifier = Modifier.padding(top = 16.dp))
                        PopSem32("UBAH", Black)
                        PopSem32("DATA MENGAJI", Primary)
                        Row {
                            PopSem32("SANTRI", Primary)
                            Image(
                                painter = painterResource(id = R.drawable.iconlaporan),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(104.dp)
                                    .height(104.dp)
                            )
                        }
                        OutlinedTextField(
                            value = name,
                            onValueChange = {},
                            readOnly = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp)
                        )
                        Row(
                            modifier = Modifier
                                .padding(top = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            OutlinedTextField(
                                value = surah,
                                onValueChange = {},
                                readOnly = true,
                                modifier = Modifier
                                    .width(217.dp)
                            )
                            Spacer(modifier = Modifier.padding(start = 8.dp))
                            OutlinedTextField(
                                value = ayat,
                                onValueChange = {},
                                readOnly = true,
                            )
                        }
                        GButton(
                            text = "Simpan",
                            onClick = {
                            },
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .fillMaxWidth()

                        )
                    }

                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLaporanMengaji() {
    LaporanMengaji()
}