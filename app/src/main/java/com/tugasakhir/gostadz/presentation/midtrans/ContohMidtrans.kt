package com.tugasakhir.gostadz.presentation.midtrans

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.time.LocalDateTime

@Composable
fun ContoMidtrans() {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(
            onClick = {
                       scope.launch{
                           requestSnap(amount = 10000,context = context)
                       }
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text("Get Payment Link")
        }
    }
}

fun requestSnap(amount:Int, order_id: String = LocalDateTime.now().toString(),context:Context) {
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
    transactionDetails.put("order_id", order_id)
    transactionDetails.put("gross_amount", amount)
    requestBody.put("transaction_details", transactionDetails)

// Convert request body to StringEntity
    val stringEntity = StringEntity(requestBody.toString())

// Make the POST request
    client.post(context, url, stringEntity, "application/json", object : JsonHttpResponseHandler() {
        override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONObject?) {
            if (response != null && response.has("redirect_url")) {
                val redirectUrl = response.getString("redirect_url")
                Log.i("XLog", "onSuccess: $redirectUrl")
            } else {
                Log.i("XLog", "onSuccess: Response tidak valid atau tidak memiliki redirect_url")
            }
        }

        override fun onFailure(statusCode: Int, headers: Array<out Header>?, throwable: Throwable?, errorResponse: JSONObject?) {
            Log.i("XLog", "onFail: $errorResponse")
        }
    })

}


object SdkConfig {
    const val MERCHANT_ID = "G202721762"
    const val CLIENT_KEY = "SB-Mid-client-TrMqS0Cz3Icmr-pK"
    const val SERVER_KEY = "SB-Mid-server-p4daLtD0NEFKwFSatkQQ_XVp"
}


@Preview
@Composable
fun PreviewContoMidtrans() {
    ContoMidtrans()
}