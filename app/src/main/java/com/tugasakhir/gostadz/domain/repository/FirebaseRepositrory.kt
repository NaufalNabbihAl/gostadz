package com.tugasakhir.gostadz.domain.repository

import com.tugasakhir.gostadz.commons.Resource
import com.tugasakhir.gostadz.domain.model.ResponseGetSantri
import com.tugasakhir.gostadz.domain.model.ResponseGetUstadz

interface FirebaseRepository {
    suspend fun getSantri(): Resource<List<ResponseGetSantri>>
    suspend fun getUstadz(): Resource<List<ResponseGetUstadz>>
}