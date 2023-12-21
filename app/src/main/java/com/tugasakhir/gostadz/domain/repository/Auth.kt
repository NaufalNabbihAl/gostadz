package com.tugasakhir.gostadz.domain.repository

import com.tugasakhir.gostadz.data.model.UserCredential

interface Auth {
    suspend fun login(user: UserCredential): String
}