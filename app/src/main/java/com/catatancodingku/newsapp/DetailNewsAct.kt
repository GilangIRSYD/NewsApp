package com.catatancodingku.newsapp

import android.os.Bundle
import android.util.Log
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.catatancodingku.newsapp.api.ApiClient
import com.catatancodingku.newsapp.model.DataBeritaItem
import kotlinx.android.synthetic.main.activity_detail_news.*
import kotlinx.android.synthetic.main.content_scrolling.*

class DetailNewsAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            val dataInten = intent.getParcelableExtra<DataBeritaItem>("DATA_PARCEL")

            tv_detail_berita.text   = dataInten?.isiBerita
            Glide.with(this)
                .load(ApiClient.URL_IMAGE + dataInten?.imageBerita)
                .error(R.drawable.ic_launcher_background)
                .into(img_detail)

            Log.d("datalempar", "onCreate:" + dataInten?.judulBerita)
            findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = dataInten?.judulBerita
        }

    }
}