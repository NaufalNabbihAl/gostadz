package com.tugasakhir.gostadz.presentation.login_masjid_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tugasakhir.gostadz.commons.Resource
import com.tugasakhir.gostadz.data.model.UserCredential
import com.tugasakhir.gostadz.domain.use_case.LoginUseCase
import com.tugasakhir.gostadz.domain.use_case.ValidateEmail
import com.tugasakhir.gostadz.domain.use_case.ValidatePassword
import com.tugasakhir.gostadz.presentation.login_tpq_screen.LoginMasjidFormEvent
import com.tugasakhir.gostadz.presentation.login_tpq_screen.LoginMasjidFormState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow

class LoginMasjidFormViewModel(
    private val login: LoginUseCase,
    private val validateEmail: ValidateEmail,
    private val validatePassword: ValidatePassword
) : ViewModel() {

    var state by mutableStateOf(LoginMasjidFormState())

    private val loginMasjidEventChannel = Channel<LoginMasjidEvent>()
    val loginMasjidEvents = loginMasjidEventChannel.receiveAsFlow()

    fun onEvent(event: LoginMasjidFormEvent) {
        when (event) {
            is LoginMasjidFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }

            is LoginMasjidFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }

            is LoginMasjidFormEvent.Submit -> {
                submitData()
            }

            is LoginMasjidFormEvent.Loading -> {
                state = state.copy(isLoading = event.isLoading)
            }

            else -> {

            }
        }
    }

    private fun submitData() {
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)

        val hasError = listOf(
            emailResult,
            passwordResult
        ).any { !it.successful }

        if (hasError) {
            state = state.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
            )
            return
        } else {
            state = state.copy(
                emailError = null,
                passwordError = null,
            )
            loginFirebase(email = state.email, password = state.password)
        }
    }

    private fun loginFirebase(email: String, password: String) {
        val data = UserCredential(email = email, password = password)
        login(data).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    loginMasjidEventChannel.send(LoginMasjidEvent.Success)
                }

                is Resource.Error -> {
                    loginMasjidEventChannel.send(LoginMasjidEvent.Error)
                }

                is Resource.Loading -> {
                    loginMasjidEventChannel.send(LoginMasjidEvent.Loading)
                }
            }
        }.launchIn(viewModelScope)
    }

    sealed class LoginMasjidEvent {
        object Success : LoginMasjidEvent()
        object Error : LoginMasjidEvent()
        object Loading : LoginMasjidEvent()
    }
}