package com.example.madskills


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

class CatlogAdapter (private val catlogs: ArrayList<CatlogClass>): RecyclerView.Adapter<CatlogAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvCatlogName: TextView = itemView.findViewById(R.id.tvCatlogName)
        val tvCatlogPrice: TextView = itemView.findViewById(R.id.tvCatlogPrice)
        val tvCatlogTime: TextView = itemView.findViewById(R.id.tvCatlogTime)
        val CatlogBgItem: ConstraintLayout = itemView.findViewById(R.id.CatlogBgItem)
        val cardCatlog: CardView = itemView.findViewById(R.id.cardCatlog)


        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
           LayoutInflater.from(parent.context)
               .inflate(R.layout.catlog, parent, false)
        return ViewHolder(itemView)

    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val catlog = catlogs[position]
        holder.CatlogBgItem.tag = catlog.catlogid
        holder.tvCatlogName.text = catlog.catlogname
        holder.tvCatlogPrice.text = "${catlog.catlogprice.toString()} ₽"
        holder.tvCatlogTime.text = catlog.catlogtime
        holder.cardCatlog.setOnClickListener { v -> (holder.itemView.context as MainFragment1).onCardViewClicked(v) }


    }

    override fun getItemCount() = catlogs.size

    }