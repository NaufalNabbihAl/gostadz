package com.tugasakhir.gostadz.presentation.menu_video_screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugasakhir.gostadz.ui.component.HomeBack
import com.tugasakhir.gostadz.ui.component.ListItemMenuVideo
import com.tugasakhir.gostadz.ui.component.poppins
import com.tugasakhir.gostadz.ui.theme.Primary
import org.koin.androidx.compose.getViewModel

@Composable
fun MenuVideo(
    viewModel: MenuVideoViewModel = getViewModel()
) {
    val scope = rememberCoroutineScope()
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Video",
            fontSize = 20.sp,
            fontFamily = poppins,
            fontWeight = FontWeight.SemiBold,
            color = Primary
        )
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(state.video ?: emptyList()) {video ->
                Log.i("XLog", "MenuVideo: $video")
                ListItemMenuVideo(
                    title = video.title,
                    photoUrl = video.photoUrl,
                    onClick = {

                    }
                )
            }
        }
        HomeBack({},{})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMenuVideo() {
MenuVideo()
}