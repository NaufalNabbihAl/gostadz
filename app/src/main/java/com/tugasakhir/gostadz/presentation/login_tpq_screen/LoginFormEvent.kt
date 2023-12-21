package com.tugasakhir.gostadz.presentation.login_tpq_screen

sealed class LoginFormEvent{
    data class EmailChanged(val email: String) : LoginFormEvent()
    data class PasswordChanged(val password: String) : LoginFormEvent()
    data class Loading(val isLoading: Boolean) : LoginFormEvent()
    object Submit : LoginFormEvent()
}
