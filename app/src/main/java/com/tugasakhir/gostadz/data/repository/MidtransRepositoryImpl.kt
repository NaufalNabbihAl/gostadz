package com.tugasakhir.gostadz.data.repository

import android.content.Context
import com.tugasakhir.gostadz.commons.Resource
import com.tugasakhir.gostadz.domain.repository.MidtransRepository
import kotlin.coroutines.suspendCoroutine

class MidtransRepositoryImpl(private  val context: Context): MidtransRepository {
    override suspend fun createMidtransSnap(amount: String,orderId:String): Resource<String> {
        return suspendCoroutine { continuation ->

        }
    }
}