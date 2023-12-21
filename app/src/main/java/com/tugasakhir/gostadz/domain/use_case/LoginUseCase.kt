package com.tugasakhir.gostadz.domain.use_case

import com.tugasakhir.gostadz.commons.Resource
import com.tugasakhir.gostadz.data.model.UserCredential
import com.tugasakhir.gostadz.domain.repository.Auth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class LoginUseCase(private val repo: Auth) {
    operator fun invoke(userCredential: UserCredential): Flow<Resource<String>> = flow {
        emit(Resource.Loading())
        val response = repo.login(userCredential)
        val message = response
        if (message == "success") {
            emit(Resource.Success(data = response))
        } else {
            emit(Resource.Error(message = message))
        }
    }
}