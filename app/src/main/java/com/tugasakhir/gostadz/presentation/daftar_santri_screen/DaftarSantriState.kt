package com.tugasakhir.gostadz.presentation.daftar_santri_screen

import com.tugasakhir.gostadz.domain.model.ResponseGetSantri

data class DaftarSantriState(
    val santris: List<ResponseGetSantri>? = emptyList(),
    val santriTemp: List<ResponseGetSantri>? = emptyList()
)
