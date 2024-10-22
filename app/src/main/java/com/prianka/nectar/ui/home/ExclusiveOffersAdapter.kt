package com.prianka.nectar.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.prianka.nectar.R
import com.prianka.nectar.data.Groceries

class ExclusiveOffersAdapter(
    var con: Context?, var list: List<Groceries>, var onItemClick: (Groceries) -> Unit
) : RecyclerView.Adapter<ExclusiveOffersAdapter.ViewHolder>() {

    inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v)
    {
        var img = v.findViewById<ImageView>(R.id.grocery_image)
        var groceryName = v.findViewById<TextView>(R.id.grocery_name)
        var groceryQuantity = v.findViewById<TextView>(R.id.grocery_quantity)
        var groceryPrice = v.findViewById<TextView>(R.id.grocery_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(con).inflate(R.layout.exclusive_offers_single_row, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val grocery = list[position]

        holder.groceryName.text = grocery.groceryName
        holder.img.load(grocery.imageUrl){
            crossfade(true)
            placeholder(R.drawable.placeholder)
            error(R.drawable.placeholder)
        }
        holder.itemView.setOnClickListener { onItemClick(grocery) }
        holder.groceryQuantity.text = "${grocery.quantity.toString()}pcs, Priceg"
        holder.groceryPrice.text = "$${grocery.price.toString()}"
    }

    override fun getItemCount(): Int {
        return list.count()
    }
//    fun updateData(newPlaces: List<Places>) {
//        this.list = newPlaces
//        notifyDataSetChanged()
//
//    }
}