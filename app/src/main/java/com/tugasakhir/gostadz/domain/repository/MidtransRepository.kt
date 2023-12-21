package com.tugasakhir.gostadz.domain.repository

import com.tugasakhir.gostadz.commons.Resource

interface MidtransRepository {
    suspend fun createMidtransSnap(amount: String,orderId:String): Resource<String>
}