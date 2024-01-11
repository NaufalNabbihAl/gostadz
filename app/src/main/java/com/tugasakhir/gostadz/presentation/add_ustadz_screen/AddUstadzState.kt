package com.tugasakhir.gostadz.presentation.add_ustadz_screen

data class AddUstadzState(
    val full_name: String = "",
    val address: String = "",
    val role: String = "",
    val formattedDate: String = "",
    val email: String = "",
    val password: String = "",
    val errorMessage: String = "",
    val successMessage: String = ""
)
