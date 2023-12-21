package com.tugasakhir.gostadz.presentation.menu_video_screen

import com.tugasakhir.gostadz.domain.model.GetVideo

data class MenuVideoState(
    val video: List<GetVideo>? = emptyList(),
)
