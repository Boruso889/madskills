package com.example.madskills

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Url

object RetrofitClient {
    private var retrofit: Retrofit? = null
    var baseUrl = ""

   fun getClient(baseUrl: String): Retrofit {
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        RetrofitClient.baseUrl = baseUrl
        return retrofit!!
    }

    private fun getRetrofit(Url: String): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(
                RxJava2CallAdapterFactory.create()
            )
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl(Url)
            .build()
    }

    fun getApiData(): Retrofit {
        val retrofitApi = getRetrofit(com.example.madskills.retro.Url.BASE_URL)
        return retrofitApi
    }

    fun callApi(): RetrofitServices {
        val retrofitCall = getApiData()
        return retrofitCall.create(RetrofitServices::class.java)
    }
}