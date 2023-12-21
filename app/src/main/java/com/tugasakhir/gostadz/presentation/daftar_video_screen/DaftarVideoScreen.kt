package com.tugasakhir.gostadz.presentation.daftar_video_screen

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugasakhir.gostadz.presentation.menu_video_screen.MenuVideoViewModel
import com.tugasakhir.gostadz.ui.component.ListItemVideo
import com.tugasakhir.gostadz.ui.component.PopSemi24
import com.tugasakhir.gostadz.ui.component.poppins
import com.tugasakhir.gostadz.ui.theme.Primary
import org.koin.androidx.compose.getViewModel

@Composable
fun DaftarVideoScreen(
    viewModel: MenuVideoViewModel = getViewModel()
) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            PopSemi24(
                text = "Daftar Video",
                color = Primary
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            OutlinedButton(
                onClick = {},
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
                    "Upload",
                    color = Color.Black,
                    fontFamily = poppins,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.W100,
                )
                Icon(
                    imageVector = Icons.Default.Upload,
                    contentDescription = null,
                    tint = Primary,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
        LazyColumn {
            items(state.video ?: emptyList()) {video ->
                Log.i("XLog", "MenuVideo: $video")
                ListItemVideo(
                    title = video.title,
                    photoUrl = video.photoUrl,
                    onEdit = {id ->
                        // TODO: Add Edit Function
                    },
                    onDelete = {id ->
                        // TODO: Add Delete Function
                    },
                    id = video.id
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDaftarVideoScreen() {
    DaftarVideoScreen()
}