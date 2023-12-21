package com.tugasakhir.gostadz.presentation.daftar_santri_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tugasakhir.gostadz.presentation.route.Route
import com.tugasakhir.gostadz.ui.component.*
import com.tugasakhir.gostadz.ui.theme.Black
import com.tugasakhir.gostadz.ui.theme.Primary
import org.koin.androidx.compose.getViewModel

@Composable
fun DaftarSantri(viewModel: DaftarSantriViewModel = getViewModel(),navController: NavHostController) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        val searchValue = viewModel.searchValue.collectAsState().value


        BackButton(onClick = {
                             navController.navigateUp()
        }, "Pilih Jenis Menu")
        Spacer(modifier = Modifier.padding(top = 16.dp))
        PopSem32("DAFTAR", Black, Modifier.padding(start = 8.dp))
        PopSem32("SANTRI", Primary, Modifier.padding(start = 48.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextFieldSearch(
                modifier = Modifier,
                value = searchValue,
                onChange = {
                    viewModel.search(it)
                },
            )
            OutlinedButton(
                onClick = {
                    navController.navigate(Route.AddSantri.route)
                },
                modifier = Modifier
                    .padding(top = 16.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Primary,
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Primary),
                contentPadding = PaddingValues(2.dp)

            ) {
                Text(
                    "TAMBAH",
                    color = Color.Black,
                    fontFamily = poppins,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.W100,
                )
                Icon(
                    imageVector = Icons.Default.PersonAdd,
                    contentDescription = null,
                    tint = Primary,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(top = 16.dp))
        LazyColumn {
            items(state.santris ?: emptyList(), key = { it.id }) { santri ->
                ListItem(
                    name = santri.full_name,
                    onClick1 = { /*TODO*/ },
                    onClick2 = { /*TODO*/ }
                )
                Spacer(modifier = Modifier.padding(top = 8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DaftarSantriPreview() {
}