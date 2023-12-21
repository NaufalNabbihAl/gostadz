package com.tugasakhir.gostadz.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugasakhir.gostadz.R
import com.tugasakhir.gostadz.data.model.ItemIcon
import com.tugasakhir.gostadz.ui.theme.Gray
import com.tugasakhir.gostadz.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardIcon(
    itemIcon: ItemIcon,
    onClick : () -> Unit
) {
    Card(
        modifier = Modifier
            .width(161.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp))
        ,
        onClick = { onClick() },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Column(
        ) {
            Image(
                painter = painterResource(id = itemIcon.image),
                contentDescription = stringResource(id = itemIcon.title),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(135.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = itemIcon.title),
                fontFamily = ibmplexsans,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                minLines = 2,
                textAlign = TextAlign.Center
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardMenu(
    onClick: () -> Unit,
    id: Int,
    title: Int,
    desc: Int,
){
    ElevatedCard(
        modifier = Modifier
            .width(345.dp)
            .height(120.dp)
        ,
        onClick = { onClick()},
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Row {
            Column (
                modifier = Modifier
                    .background(Primary)
                    .fillMaxHeight()
                    .width(122.05.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Icon(
                    painter = painterResource(id = id),
                    contentDescription = null,
                    tint = Color.White,
                    )
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 8.dp)
                ,
                horizontalAlignment = Alignment.Start,
            ){
                Spacer(modifier = Modifier.padding(top = 24.dp))
                PopSemi14(text = stringResource(id = title), color = Primary)
                PopReg12(text = stringResource(id = desc), color = Gray)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun CardIconPreview() {

  CardMenu(onClick = { /*TODO*/ }, id = R.drawable.list_alt, title = R.string.JadwalKegiatan, desc = R.string.Lihatjadwal)
}