package com.zireddinismayilov.foodsapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.zireddinismayilov.foodsapi.Model.ResultDTO
import com.zireddinismayilov.foodsapi.R

class foodCategoryAdapter(var list: ResultDTO) : RecyclerView.Adapter<foodCategoryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image = itemView.findViewById<ImageView>(R.id.imageView)
        var categoryName = itemView.findViewById<TextView>(R.id.category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_element_category, parent, false))
    }

    override fun getItemCount(): Int {
        return list.meals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var imageView = holder.image
        Picasso.get().load(list.meals[position].strMealThumb).resize(450, 350).centerCrop().into(imageView)
        holder.categoryName.setText(list.meals[position].strMeal)

    }
}