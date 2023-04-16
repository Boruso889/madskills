package com.example.madskills

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class NewsAdapter (private val news: ArrayList<NewsClass>): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvNewsName: TextView = itemView.findViewById(R.id.tvNewsName)
        val tvNewsDesc: TextView = itemView.findViewById(R.id.tvNewsDesc)
        val tvNewsPrice: TextView = itemView.findViewById(R.id.tvNewsPrice)
        val ivNews: ImageView = itemView.findViewById(R.id.ivNews)
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.news, parent, false)
            return ViewHolder(itemView)
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val new = news[position]
        holder.tvNewsPrice.text = "${new.newsprice.toString()} ₽ "
        holder.tvNewsName.text = new.newsname
        holder.tvNewsDesc.text = new.newsdesc

    }

    override fun getItemCount() = news.size


}