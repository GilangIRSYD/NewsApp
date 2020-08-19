package com.catatancodingku.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.catatancodingku.newsapp.api.ApiClient
import com.catatancodingku.newsapp.model.ResponseNews
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callApi()

        swipe_toMagic.setOnRefreshListener {
            callApi()
            swipe_toMagic.isRefreshing = false
        }
    }

    fun callApi(){
        ApiClient.service.getDataBerita("tb_berita").enqueue(object : Callback<ResponseNews>{
            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                Log.d("RESPONSE", "onFailure: ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                if (response.isSuccessful){
                    val responseNews : ResponseNews? = response.body()
                    val message : String? = responseNews?.message

                    Log.d("RESPONSE", "onResponse: $message")

                    val dataBerita = responseNews?.dataBerita
                    val dataset = dataBerita?.get(0)
                    val subData  = dataset?.imageBerita

                    Log.d("RESPONSE", "onResponse: $subData")

                    dataBerita?.forEach {
                        val judul = it?.judulBerita
                        Log.d("RESPONSE", "onResponse: $judul")
                    }

                    val adapter  = AdapterNews(this@MainActivity,dataBerita)
                    rv_main.adapter = adapter
                    rv_main.layoutManager = LinearLayoutManager(this@MainActivity)
                    rv_main.setHasFixedSize(true)

                }
            }

        })
    }
}