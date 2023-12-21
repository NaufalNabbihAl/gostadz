package com.tugasakhir.gostadz.presentation.santri_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugasakhir.gostadz.R
import com.tugasakhir.gostadz.ui.component.*
import com.tugasakhir.gostadz.ui.theme.Black
import com.tugasakhir.gostadz.ui.theme.Primary

@Composable
fun Santri() {
    Column(modifier = Modifier.padding(16.dp)) {
        TopBarText(onClick = {},"Naufal Nabbih Al Shiddiq")
        Spacer(modifier = Modifier.padding(top = 36.dp))
        Row(
            horizontalArrangement = Arrangement.Start
        ) {

            Image(
                painter = painterResource(id = R.drawable.iconsantri),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .width(192.dp)
                    .height(256.dp),
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Card (
                colors = CardDefaults.cardColors(containerColor = Primary),
            ){
                Row (
                ){
                    Column (
                        modifier = Modifier.padding(start = 24.dp, top = 24.dp)
                    ){
                        Row{
                            Icon(
                                painter = painterResource(id = R.drawable.book),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(16.dp)
                                    .height(16.dp),
                                tint = Color.White
                            )
                            Text(
                                text = "Terakhir Dibaca",
                                style = TextStyle(
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = poppins,
                                    fontSize = 8.sp,
                                    color = Color.White
                                )
                            )
                        }
                        Text(
                            text = "Al-Waqiah",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = poppins,
                                fontSize = 16.sp,
                                color = Color.White
                            )

                        )
                        Text(
                            text = "Ayat No : 56",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = poppins,
                                fontSize = 10.sp,
                                color = Color.White
                            )

                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.iconbook),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 36.dp, end = 36.dp)
                            .width(99.dp)
                            .height(109.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(top = 48.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PopBold13(text = stringResource(id = R.string.About), color = Black)
            PopReg12(text = stringResource(id = R.string.Islami), color = Black)
            Spacer(modifier = Modifier.padding(top = 32.dp))
            GButton(text = "Logout") {}
        }

    }
}


@Preview(showBackground = true)
@Composable
fun SantriPrev() {
//    Santri(navController)
}

