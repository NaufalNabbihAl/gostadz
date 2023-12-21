package com.tugasakhir.gostadz.presentation.jadwal_kegiatan_screen

import com.tugasakhir.gostadz.domain.model.GetJadwal

data class JadwalKegiatanState(
    val jadwal: List<GetJadwal>? = emptyList(),
)
