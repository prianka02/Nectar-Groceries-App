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
import com.prianka.nectar.data.Categories
import com.prianka.nectar.data.Groceries

class ExploreProductsAdapter(
    private var con: Context?, var list: List<Categories>, var onItemClick: (Categories) -> Unit
) : RecyclerView.Adapter<ExploreProductsAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val img = v.findViewById<ImageView>(R.id.category_item_image)
        var categoryName = v.findViewById<TextView>(R.id.category_item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(con).inflate(R.layout.explore_product_single_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = list[position]

        holder.categoryName.text = category.categoryName
        holder.img.load(category.imageUrl) {
            crossfade(true)
            placeholder(R.drawable.placeholder)
        }
        holder.itemView.setOnClickListener { onItemClick(category) }
    }

    override fun getItemCount(): Int {
        return list.count()
    }
}