package com.tugasakhir.gostadz.domain.use_case

import android.util.Log
import com.tugasakhir.gostadz.commons.Resource
import com.tugasakhir.gostadz.domain.model.ResponseGetSantri
import com.tugasakhir.gostadz.domain.repository.FirebaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSantri(
    private val repository: FirebaseRepository
) {
    operator fun invoke(): Flow<Resource<List<ResponseGetSantri>>> = flow {
        Log.d("XLog", "GetSantri: Emit Loading")
        val response = repository.getSantri()
        when (response) {
            is Resource.Loading -> {
                Log.d("XLog", "GetSantri: Emit Loading")
                emit(response)
            }

            is Resource.Error -> {
                Log.d("XLog", "GetSantri: Emit Error - ${response.message}")
                emit(response)
            }

            is Resource.Success -> {
                Log.d("XLog", "GetSantri: Emit Success ${response.data}")
                emit(response)
            }
        }
    }
}