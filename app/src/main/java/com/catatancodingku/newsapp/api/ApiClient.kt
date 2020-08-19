package com.catatancodingku.newsapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    const val BASE_URL  = "http://192.168.60.146/portal_berita/"
    const val URL_IMAGE  = BASE_URL + "image/"

    var retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service : ApiService = retrofit.create(ApiService::class.java)
}