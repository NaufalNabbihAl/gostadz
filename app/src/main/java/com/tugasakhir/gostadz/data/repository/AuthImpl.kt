package com.tugasakhir.gostadz.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.tugasakhir.gostadz.data.model.UserCredential
import com.tugasakhir.gostadz.domain.repository.Auth
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AuthImpl(private val auth:FirebaseAuth) :  Auth {
    override suspend fun login(user: UserCredential): String {
        return suspendCoroutine { continuation ->
            auth.signInWithEmailAndPassword(user.email, user.password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        continuation.resume("success")
                    } else {
                        continuation.resume( "error")
                    }
                }
        }
    }
}