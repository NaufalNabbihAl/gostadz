package com.tugasakhir.gostadz.presentation.jadwal_kegiatan_screen

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.tugasakhir.gostadz.domain.model.GetJadwal
import kotlinx.coroutines.launch

class JadwalKegiatanViewModel(private val db: FirebaseFirestore) : ViewModel() {
    val _state = mutableStateOf(JadwalKegiatanState())
    val state: State<JadwalKegiatanState> = _state

    init {
        viewModelScope.launch {
            db.collection("Jadwal Kegiatan")
                .get()
                .addOnSuccessListener { documents ->
                    val result = documents.map { data ->
                        GetJadwal(
                            id = data.id,
                            kegiatan = data.data["kegiatan"].toString(),
                            jam = data.data["jam"].toString(),
                            tanggal = data.data["tanggal"].toString()
                        )
                    }

                    _state.value = state.value.copy(jadwal = result)
                    Log.i("XLog", "JadwalKegiatan: $result")
                }
                .addOnFailureListener { exception ->
                    Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                }
        }
    }

}