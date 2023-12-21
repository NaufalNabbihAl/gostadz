package com.tugasakhir.gostadz.presentation.login_tpq_screen

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
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow

class LoginFormViewModel(
    private val login: LoginUseCase,
    private val validateEmail: ValidateEmail,
    private val validatePassword: ValidatePassword
) : ViewModel() {

    var state by mutableStateOf(LoginFormState())

    private val loginEventChannel = Channel<LoginEvent>()
    val loginEvents = loginEventChannel.receiveAsFlow()

    fun onEvent(event: LoginFormEvent) {
        when (event) {
            is LoginFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }

            is LoginFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }

            is LoginFormEvent.Submit -> {
                submitData()
            }
            is LoginFormEvent.Loading -> {
                state = state.copy(isLoading = event.isLoading)
            }else -> {

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
                    loginEventChannel.send(LoginEvent.Success)
                }

                is Resource.Error -> {
                    loginEventChannel.send(LoginEvent.Error)
                }

                is Resource.Loading -> {
                    loginEventChannel.send(LoginEvent.Loading)
                }
            }
        }.launchIn(viewModelScope)
    }

    sealed class LoginEvent {
        object Success : LoginEvent()
        object Error : LoginEvent()
        object Loading : LoginEvent()
    }

}