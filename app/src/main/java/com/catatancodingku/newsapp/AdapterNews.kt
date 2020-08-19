package com.catatancodingku.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.catatancodingku.newsapp.api.ApiClient
import com.catatancodingku.newsapp.model.DataBeritaItem
import kotlinx.android.synthetic.main.item_row_berita.view.*


class AdapterNews (
    val context: Context,
    val dataNews : List<DataBeritaItem?>?
) : RecyclerView.Adapter<AdapterNews.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsTitle = itemView.item_tvTitle_news
        val newsImage = itemView.item_ivNews
        val newsDesc  = itemView.item_tvNews_desc
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_row_berita,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = dataNews?.size?:0

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.newsTitle.text   = dataNews?.get(position)?.judulBerita
        holder.newsDesc.text    = dataNews?.get(position)?.isiBerita


        val image = ApiClient.URL_IMAGE + dataNews?.get(position)?.imageBerita
        Glide.with(context).load(image).
                error(R.drawable.ic_launcher_background).
                into(holder.newsImage)

        holder.itemView.setOnClickListener {
            val intent = Intent(context,DetailNewsAct::class.java)
            intent.putExtra("DATA_PARCEL" , dataNews?.get(position))
            context.startActivity(intent)
        }

    }
}