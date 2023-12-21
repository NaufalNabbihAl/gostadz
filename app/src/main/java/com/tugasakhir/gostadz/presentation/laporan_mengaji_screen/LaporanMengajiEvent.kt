package com.tugasakhir.gostadz.presentation.laporan_mengaji_screen

sealed class LaporanMengajiEvent {
    data class ChangeDialog(val showDialog:Boolean) : LaporanMengajiEvent()
    data class ChangeSelectedId(val selectedId:String) : LaporanMengajiEvent()
}