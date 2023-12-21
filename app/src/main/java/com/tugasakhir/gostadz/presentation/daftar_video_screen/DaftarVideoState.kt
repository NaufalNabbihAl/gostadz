package com.tugasakhir.gostadz.presentation.daftar_video_screen

import com.tugasakhir.gostadz.domain.model.GetVideo

data class DaftarVideoState(
    val video: List<GetVideo>? = emptyList(),
)
