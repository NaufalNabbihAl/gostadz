package com.tugasakhir.gostadz.presentation.add_santri_screen

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AddSantriViewModel(
    private val firebaseFirestore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth,
    private val context: Context
) :
    ViewModel() {
    var state by mutableStateOf(AddSantriState())

    fun onEvent(event: AddSantriEvent) {
        when (event) {
            is AddSantriEvent.OnGenderChanged -> {
                state = state.copy(gender = event.gender)
            }

            is AddSantriEvent.OnDateChanged -> {
                state = state.copy(formattedDate = event.date)
            }

            is AddSantriEvent.OnAddressChanged -> {
                state = state.copy(address = event.address)
            }

            is AddSantriEvent.OnFullNameChanged -> {
                state = state.copy(full_name = event.full_name)
            }

            is AddSantriEvent.OnEmailChanged -> {
                state = state.copy(email = event.email)
            }

            is AddSantriEvent.OnPasswordChanged -> {
                state = state.copy(password = event.password)
            }

            is AddSantriEvent.DialogSuccessDismissed -> {
                state = state.copy(successMessage = "")
            }

            is AddSantriEvent.DialogErrorDismissed -> {
                state = state.copy(errorMessage = "")
            }

            is AddSantriEvent.OnSubmit -> {
                submit()
            }
        }
    }

    private fun submit() {
        firebaseAuth.createUserWithEmailAndPassword(state.email, state.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    createDetailUser()
                }
            }
    }

    private fun createDetailUser() {
        val infaq = hashMapOf(
            "email" to state.email,
            "full_name" to state.full_name,
            "address" to state.address,
            "gender" to state.gender,
            "tgl_lahir" to state.formattedDate,
        )
        firebaseFirestore.collection("Santri")
            .add(infaq)
            .addOnSuccessListener { documentReference ->
                state = state.copy(successMessage = "Sukses Menambah Transaksi")
            }
            .addOnFailureListener { e ->
                state = state.copy(errorMessage = "Error ${e.localizedMessage}")
            }
    }
}