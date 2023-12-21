package com.tugasakhir.gostadz.presentation.daftar_video_screen

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.tugasakhir.gostadz.domain.model.GetVideo
import com.tugasakhir.gostadz.presentation.menu_video_screen.MenuVideoState
import kotlinx.coroutines.launch

class DaftarVideoViewModel(private val db: FirebaseFirestore) : ViewModel() {
    val _state = mutableStateOf(MenuVideoState())
    val state: State<MenuVideoState> = _state

    init {
        viewModelScope.launch {
            db.collection("Video Ceramah")
                .get()
                .addOnSuccessListener { documents ->
                    val result = documents.map { data ->
                        GetVideo(
                            id = data.id,
                            title = data.data["title"].toString(),
                            photoUrl = data.data["photoUrl"].toString(),
                            description = data.data["description"].toString(),
                            videoId = data.data["videoId"].toString()
                        )
                    }
                    _state.value = state.value.copy(video = result)
                    Log.i("XLog", "Video: $result")
                }
                .addOnFailureListener { exception ->
                    Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                }
        }
    }
}