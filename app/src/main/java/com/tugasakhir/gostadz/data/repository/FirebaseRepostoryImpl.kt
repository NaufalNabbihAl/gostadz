package com.tugasakhir.gostadz.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.FirebaseException
import com.google.firebase.firestore.FirebaseFirestore
import com.tugasakhir.gostadz.commons.Resource
import com.tugasakhir.gostadz.domain.model.ResponseGetSantri
import com.tugasakhir.gostadz.domain.model.ResponseGetUstadz
import com.tugasakhir.gostadz.domain.repository.FirebaseRepository
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class FirebaseRepostoryImpl(private val db: FirebaseFirestore) : FirebaseRepository {
    override suspend fun getSantri(): Resource<List<ResponseGetSantri>> {
        Log.d("XLog", "getSantri: Called")

        return try {
            val santriDeferred = suspendCoroutine { continuation ->
                db.collection("Santri")
                    .get()
                    .addOnSuccessListener { documents ->
                        val result = documents.map { data ->
                            ResponseGetSantri(
                                id = data.id,
                                full_name = data.data["full_name"].toString(),
                                surah = data.data["surah"].toString(),
                                ayat = data.data["ayat"].toString(),
                            )
                        }
                        Log.i(TAG, "getSantriss: $result")
                        continuation.resume(result)
                    }
                    .addOnFailureListener { exception ->
                        Log.w(TAG, "Error getting documents: ", exception)
                        continuation.resumeWithException(exception)
                    }
            }

            Resource.Success(data = santriDeferred)
        } catch (e: FirebaseException) {
            // Handle exceptions, log, or throw if needed
            Log.e(TAG, "Error getting documents$e")
            Resource.Error(message = e.message ?: "An unknown error occurred")
        }
    }

    override suspend fun getUstadz(): Resource<List<ResponseGetUstadz>> {
        Log.d("XLog", "getSantri: Called")

        return try {
            val ustadzDeferred = suspendCoroutine { continuation ->
                db.collection("Ustadz")
                    .get()
                    .addOnSuccessListener { documents ->
                        val result = documents.map { data ->
                            ResponseGetUstadz(
                                id = data.id,
                                name = data.data["name"].toString()
                            )
                        }
                        Log.i(TAG, "getUstadzs: $result")
                        continuation.resume(result)
                    }
                    .addOnFailureListener { exception ->
                        Log.w(TAG, "Error getting documents: ", exception)
                        continuation.resumeWithException(exception)
                    }
            }

            Resource.Success(data = ustadzDeferred)
        } catch (e: FirebaseException) {
            // Handle exceptions, log, or throw if needed
            Log.e(TAG, "Error getting documents$e")
            Resource.Error(message = e.message ?: "An unknown error occurred")
        }
    }
}