package com.example.madskills

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val names: List<String>):

    RecyclerView.Adapter<ListAdapter.ViewHolder>()
    {
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val popular: TextView = itemView.findViewById(R.id.tvPopular)
            val covid: TextView = itemView.findViewById(R.id.tvCovid)
            val complex: TextView = itemView.findViewById(R.id.tvComplex)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
            val itemView =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_main, parent, false)
            return ViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.popular.tag = position
            holder.covid.text = "Covid"
            holder.complex.text = "Комплексные"
        }

        override fun getItemCount() = names.size
        }

