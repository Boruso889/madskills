/*package com.example.madskills.auth

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson

class ApiService : AppCompatActivity() {
    private val clientId = "" //add your client id
    private val clientSecret = "" //add your client secret
    private val apigeeTokenUrl = "" // url to get the token
    private val grantType = "client_credentials"

    var token: String? = null
    var tokenType: String? = null


    private fun setAuthToken() {
        try {
            val (request, response, result) = apigeeTokenUrl.httpPost(listOf(
                "grant_type" to grantType,
            ))
                .authentication().basic(clientId, clientSecret)
                .responseString()

            when (result) {
                is Result.Success -> {
                    var gson = Gson()
                    val tokenResultJson = gson.fromJson(result.value, AuthResult::class.java)
                    token = tokenResultJson!!.access_token!!
                    tokenType = tokenResultJson!!.token_type!!
                    Log.d(ContentValues.TAG, "token $token")
                    Log.d(ContentValues.TAG, "token type $tokenType")
                }
                is Result.Failure -> {
                    // handle error
                }
            }

        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    init {
        setAuthToken()
    }
}*/