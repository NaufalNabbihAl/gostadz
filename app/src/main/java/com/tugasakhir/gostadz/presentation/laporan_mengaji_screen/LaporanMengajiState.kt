package com.tugasakhir.gostadz.presentation.laporan_mengaji_screen

import com.tugasakhir.gostadz.domain.model.ResponseGetSantri

data class LaporanMengajiState(
    val laporans: List<ResponseGetSantri>? = emptyList(),
    val laporansTemp: List<ResponseGetSantri>? = emptyList(),
    val showEditDialog:Boolean = false,
    val selectedId:String   = ""
)
