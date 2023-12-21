package com.tugasakhir.gostadz.presentation.login_tpq_screen

data class LoginMasjidFormState(
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val isLoading: Boolean = false,
)
