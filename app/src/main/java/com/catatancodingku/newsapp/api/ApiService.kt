package com.catatancodingku.newsapp.api

import com.catatancodingku.newsapp.model.ResponseNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("lihat_berita.php")
    fun getDataBerita(@Query("table") namaTable : String) : Call<ResponseNews>

}