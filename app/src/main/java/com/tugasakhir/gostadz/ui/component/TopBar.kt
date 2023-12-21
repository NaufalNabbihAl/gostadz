package com.tugasakhir.gostadz.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugasakhir.gostadz.ui.theme.Primary

@Composable
fun TopBarText(onClick: () -> Unit, text: String) {


    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
        ,
        horizontalArrangement = Arrangement.End,
    ){
        Text(
            text = text,
            modifier = Modifier
                .padding(16.dp)
            ,
            color = Primary,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = poppins
            )
        IconButton(
            onClick = { onClick}
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Account",
                tint = Primary,
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
            )
        }

    }
}

@Composable
fun TopBar(onClick: () -> Unit) {


    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ,
        horizontalArrangement = Arrangement.End,
    ){
        IconButton(
            onClick = { onClick()}
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Account",
                tint = Primary,
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
            )
        }

    }
}



@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBarText(onClick = {}, text = "Admin")
}