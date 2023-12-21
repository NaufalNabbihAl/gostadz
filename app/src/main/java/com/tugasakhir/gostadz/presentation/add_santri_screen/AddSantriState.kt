package com.tugasakhir.gostadz.presentation.add_santri_screen

data class AddSantriState(
    val full_name: String = "",
    val address: String = "",
    val gender: String = "",
    val formattedDate: String = "",
    val email: String = "",
    val password: String = "",
    val errorMessage: String = "",
    val successMessage: String = ""
)