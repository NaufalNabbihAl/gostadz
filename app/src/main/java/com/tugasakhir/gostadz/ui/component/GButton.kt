package com.tugasakhir.gostadz.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugasakhir.gostadz.ui.theme.Primary


@Composable
fun GButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Primary
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .width(320.dp)
            .height(56.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            fontFamily = poppins
        )
    }
}

@Composable
fun WButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .width(320.dp)
            .height(56.dp)
    ) {
        Text(
            text = text,
            color = Primary,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            fontFamily = poppins
        )
    }
}


@Composable
fun HomeBack(onClick: () -> Unit,onClick2: () -> Unit){
    Row (
        modifier = Modifier
            .border(1.dp, Color.White)
            .background(Primary, RoundedCornerShape(10.dp))
            .width(366.dp)
            .height(56.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(
            onClick = { onClick },
            modifier = Modifier
                .padding(start = 64.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Home",
                tint = Color.White,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
        }

        IconButton(
            onClick = { onClick2 },
            modifier = Modifier
                .padding(end = 64.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
        }

    }
}



@Composable
fun BackButton(onClick: () -> Unit, text : String){
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        contentPadding = PaddingValues(0.dp),
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBackIosNew,
            contentDescription = "Back",
            tint = Primary
        )
        Spacer(modifier = Modifier.padding(start = 8.dp))
        Text(
            text = text,
            color = Primary,
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        )
    }
}




@Preview
@Composable
fun PreviewBackButton(){
    HomeBack({},{})
}

