package com.tugasakhir.gostadz.presentation.laporan_mengaji_screen

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tugasakhir.gostadz.domain.model.ResponseGetSantri
import com.tugasakhir.gostadz.domain.use_case.GetSantri
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LaporanMengajiViewModel(private val getSantri: GetSantri) : ViewModel() {
    private val daftarLaporanEvent = Channel<DaftarLaporanEvent>()
    val loginEvents = daftarLaporanEvent.receiveAsFlow()
    private val _state = mutableStateOf(LaporanMengajiState())
    val state: State<LaporanMengajiState> = _state

    fun onEvent(event: LaporanMengajiEvent) {
        when(event) {
            is LaporanMengajiEvent.ChangeDialog -> {
                _state.value = state.value.copy(showEditDialog = event.showDialog)
            }

            is LaporanMengajiEvent.ChangeSelectedId -> {
                _state.value = state.value.copy(selectedId = event.selectedId)

            }
        }
    }

    init {
        viewModelScope.launch {
            val db = Firebase.firestore
            db.collection("Santri")
                .get()
                .addOnSuccessListener { documents ->
                    val result = documents.map { data ->
                        ResponseGetSantri(
                            id = data.id,
                            full_name = data.data["full_name"].toString(),
                            surah = data.data["surah"].toString(),
                            ayat = data.data["ayat"].toString(),
                        )
                    }
                    _state.value = state.value.copy(laporans = result)
                    _state.value = state.value.copy(laporansTemp = result)
                }
                .addOnFailureListener { exception ->
                    Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                }
        }
    }

    private val _searchValue = MutableStateFlow("")
    val searchValue = _searchValue.asStateFlow()

    fun search(query: String) {
        _searchValue.update { query }
        viewModelScope.launch {
            val filter = state.value.laporans?.filter {
                it.full_name.contains(query, ignoreCase = true)
            }
            if (query.isEmpty()) {
                _state.value = state.value.copy(laporans = state.value.laporansTemp)
            } else {
                _state.value = state.value.copy(laporans = filter)
            }
        }
    }




    sealed class DaftarLaporanEvent {
        object Success : DaftarLaporanEvent()
        object Error : DaftarLaporanEvent()
        object Loading : DaftarLaporanEvent()
    }

}