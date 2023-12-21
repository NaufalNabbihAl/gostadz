package com.tugasakhir.gostadz.presentation.video_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.tugasakhir.gostadz.ui.component.HomeBack
import com.tugasakhir.gostadz.ui.component.PopSemi24
import com.tugasakhir.gostadz.ui.theme.Primary
import kotlinx.coroutines.launch

@Composable
fun VideoPlayer(videoId: String = "izYUMrsvVDQ") {
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AndroidView(
            modifier = Modifier
                .width(346.dp)
                .height(197.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                ),
            factory = {
                val view = YouTubePlayerView(it)
                view.addYouTubePlayerListener(
                    object : AbstractYouTubePlayerListener() {
                        override fun onReady(youTubePlayer: YouTubePlayer) {
                            super.onReady(youTubePlayer)
                            scope.launch {
                                youTubePlayer.loadVideo(videoId, 0f)
                            }
                        }
                    }
                )
                view
            })

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            PopSemi24(
                text = "Kunci Sukses & Bahagia di 3 Alam ",
                color = Primary
            )
        }
        Text(
            text = "Ustadz Dr. Syafiq Riza Basalamah, MA",
            modifier = Modifier.padding(top = 8.dp),
            color = Primary
        )
        Spacer(modifier = Modifier.padding(top = 424.dp))
        HomeBack(
            {},{}
        )
    }
}