package com.tugasakhir.gostadz.presentation.infaq_screen

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.json.JSONObject
import java.time.LocalDate
import kotlin.random.Random

class InfaqViewModel(private val db: FirebaseFirestore, private val context: Context) : ViewModel() {
    var state by mutableStateOf(InfaqState())

    fun onEvent(event: InfaqEvent) {
        when (event) {
            is InfaqEvent.FormChanged -> {
                state = state.copy(amount = event.amount)
            }

            is InfaqEvent.Selected1 -> {
                state = state.copy(selected1 = event.selected1)
            }

            is InfaqEvent.Selected2 -> {
                state = state.copy(selected2 = event.selected2)
            }

            is InfaqEvent.Selected3 -> {
                state = state.copy(selected3 = event.selected3)

            }

            is InfaqEvent.DialogErrorDismissed -> {
                state = state.copy(errorMessage = event.msg)
            }

            is InfaqEvent.DialogSuccessDismissed -> {
                state = state.copy(successMessage = event.msg)
            }

            is InfaqEvent.Pay -> {
                insertInfaq()
            }

        }
    }

    private fun insertInfaq() {
        val dateToday = LocalDate.now().toString()
        val infaq = hashMapOf(
            "tanggal" to dateToday,
            "jumlah" to state.amount
        )

        db.collection("Infaq")
            .add(infaq)
            .addOnSuccessListener { documentReference ->
                state = state.copy(successMessage = "Sukses Menambah Transaksi")
            }
            .addOnFailureListener { e ->
                state = state.copy(errorMessage = "Error ${e.localizedMessage}")
            }
        val orderId = dateToday + Random.nextInt(0, 99999)
        val url = "https://app.sandbox.midtrans.com/snap/v1/transactions"
        val client = AsyncHttpClient()
        val auth = "U0ItTWlkLXNlcnZlci1wNGRhTHREME5FRkt3RlNhdGtRUV9YVnA6"

        // Set headers
        client.addHeader("accept", "application/json")
        client.addHeader("content-type", "application/json")
        client.addHeader("Authorization", "Basic $auth")

        // Set request body
        val requestBody = JSONObject()
        val transactionDetails = JSONObject()
        transactionDetails.put("order_id", orderId)
        transactionDetails.put("gross_amount", state.amount.toInt())
        requestBody.put("transaction_details", transactionDetails)

        // Convert request body to StringEntity
        val stringEntity = StringEntity(requestBody.toString())

        // Make the POST request
        client.post(context, url, stringEntity, "application/json", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONObject?) {
                val redirectUrlResponse = response?.getString("redirect_url")
                // Use the coroutine context to emit the result
                state = state.copy(redirectUrl = redirectUrlResponse ?: "")
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                throwable: Throwable?,
                errorResponse: JSONObject?
            ) {
                val error = errorResponse?.getString("message")
                // Use the coroutine context to emit the result
                state = state.copy(errorMessage = error ?: "")
            }
        })
    }

}