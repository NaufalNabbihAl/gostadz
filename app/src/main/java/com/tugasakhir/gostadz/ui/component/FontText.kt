package com.tugasakhir.gostadz.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.tugasakhir.gostadz.ui.theme.Black

@Composable
fun PopSem32(text : String, color: Color,modifier: Modifier= Modifier) {
    Text(
        text = text,
        fontFamily = poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        color = color,
        modifier = modifier
    )
}
@Composable
fun IbmSem32(text : String, color: Color) {
    Text(
        text = text,
        fontFamily = ibmplexsans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        color = color
    )
}

@Composable
fun PopBold13(text : String, color: Color) {
    Text(
        text = text,
        fontFamily = poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        color = color
    )
}

@Composable
fun PopMedium24(text : String, color: Color) {
    Text(
        text = text,
        fontFamily = poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        color = color
    )
}

@Composable
fun PopSemi48(text : String, color: Color) {
    Text(
        text = text,
        fontFamily = poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 48.sp,
        color = color
    )
}

@Composable
fun PopSemi24(text : String, color: Color) {
    Text(
        text = text,
        fontFamily = poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        color = color
    )
}

@Composable
fun PopReg12(text : String, color: Color) {
    Text(
        text = text,
        fontFamily = poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = color
    )
}

@Composable
fun PopSemi14(text : String, color: Color) {
    Text(
        text = text,
        fontFamily = poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        color = color
    )
}

@Composable
fun PopMed14(text : String, color: Color) {
    Text(
        text = text,
        fontFamily = poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = color
    )
}


@Composable
fun PopReg16(text : String, color: Color) {
    Text(
        text = text,
        fontFamily = poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = color
    )
}



@Preview(showBackground = true)
@Composable
fun PreviewPopSemi24() {
    PopSemi24(text = "Pilih Nominal", color = Black)
}