package com.tugasakhir.gostadz.domain.use_case

import android.util.Log
import com.tugasakhir.gostadz.commons.Resource
import com.tugasakhir.gostadz.domain.model.ResponseGetUstadz
import com.tugasakhir.gostadz.domain.repository.FirebaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetUstadz(private val repository: FirebaseRepository) {
    operator fun invoke(): Flow<Resource<List<ResponseGetUstadz>>> = flow {
        Log.d("XLog", "GetUstadz: Emit Loading")
        val response = repository.getUstadz()
        when (response) {
            is Resource.Loading -> {
                Log.d("XLog", "GetUstadz: Emit Loading")
                emit(response)
            }

            is Resource.Error -> {
                Log.d("XLog", "GetUstadz: Emit Error - ${response.message}")
                emit(response)
            }

            is Resource.Success -> {
                Log.d("XLog", "GetUstadz: Emit Success ${response.data}")
                emit(response)
            }
        }
    }
}