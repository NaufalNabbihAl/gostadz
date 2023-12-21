package com.tugasakhir.gostadz.presentation.daftar_ustadz_screen

import com.tugasakhir.gostadz.domain.model.ResponseGetUstadz

data class DaftarUstadzState(
    val ustadzs: List<ResponseGetUstadz>? = emptyList(),
    val ustadzTemp: List<ResponseGetUstadz>? = emptyList()
)
