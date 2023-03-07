package com.example.madskills

import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {

    @GET("api/news")
    fun getNews(): Call<ArrayList<NewsClass>> // Получить список

    @GET("api/catalog")
    fun getCatlog(): Call<ArrayList<CatlogClass>>

}