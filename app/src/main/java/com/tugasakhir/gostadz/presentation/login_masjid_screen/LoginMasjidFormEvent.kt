package com.tugasakhir.gostadz.presentation.login_tpq_screen

sealed class LoginMasjidFormEvent{
    data class EmailChanged(val email: String) : LoginMasjidFormEvent()
    data class PasswordChanged(val password: String) : LoginMasjidFormEvent()
    data class Loading(val isLoading: Boolean) : LoginMasjidFormEvent()
    object Submit : LoginMasjidFormEvent()
}
