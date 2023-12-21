package com.tugasakhir.gostadz.domain.use_case

import android.util.Log
import com.tugasakhir.gostadz.commons.Resource
import com.tugasakhir.gostadz.domain.repository.MidtransRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CreateMidtrans(private val midtransRepository: MidtransRepository) {

    operator fun invoke(amount: String, orderId: String): Flow<Resource<String>> = flow {
        Log.i("XLog", "invoke: Create Midtrans")
        emit(Resource.Loading())
        val response = midtransRepository.createMidtransSnap(amount, orderId)
        if (!response.message.isNullOrEmpty()) {
            Log.i("XLog", "invoke: Create Midtrans Success")
            emit(Resource.Success(data = response.data ?: ""))
        } else {
            Log.i("XLog", "invoke: Create Midtrans Error")
            emit(Resource.Error(message = response.message ?: ""))
        }
    }

}