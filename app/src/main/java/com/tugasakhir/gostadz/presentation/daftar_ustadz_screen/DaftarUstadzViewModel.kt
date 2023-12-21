package com.tugasakhir.gostadz.presentation.daftar_ustadz_screen

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.tugasakhir.gostadz.domain.model.ResponseGetUstadz
import com.tugasakhir.gostadz.domain.use_case.GetUstadz
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DaftarUstadzViewModel(private val getUstadz: GetUstadz) : ViewModel() {

    private val daftarUstadzEvent = Channel<DaftarUstadzEvent>()
    val loginEvents = daftarUstadzEvent.receiveAsFlow()
    private val _state = mutableStateOf(DaftarUstadzState())
    val state: State<DaftarUstadzState> = _state

    init {
        viewModelScope.launch {
            val db = Firebase.firestore
            db.collection("Ustadz_Ustadzah")
                .get()
                .addOnSuccessListener { documents ->
                    val result = documents.map { data ->
                        ResponseGetUstadz(
                            name = data.data["name"].toString(),
                            id = data.id
                        )
                    }
                    _state.value = state.value.copy(ustadzs = result)
                    _state.value = state.value.copy(ustadzTemp =  result)
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
            val filter = state.value.ustadzs?.filter {
                it.name.contains(query, ignoreCase = true)
            }
            if (query.isEmpty()) {
                _state.value = state.value.copy(ustadzs = state.value.ustadzTemp)
            } else {
                _state.value = state.value.copy(ustadzs = filter)
            }
        }
    }


    sealed class DaftarUstadzEvent {
        object Success : DaftarUstadzEvent()
        object Error : DaftarUstadzEvent()
        object Loading : DaftarUstadzEvent()
    }
}