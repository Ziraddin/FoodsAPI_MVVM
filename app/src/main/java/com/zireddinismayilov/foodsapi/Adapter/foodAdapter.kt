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

class foodAdapter(var list: ResultDTO) : RecyclerView.Adapter<foodAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image = itemView.findViewById<ImageView>(R.id.imageView)
        var foodName = itemView.findViewById<TextView>(R.id.category)
        var category = itemView.findViewById<TextView>(R.id.strCategory)
        var originCountry = itemView.findViewById<TextView>(R.id.strArea)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_element, parent, false))
    }

    override fun getItemCount(): Int {
        return list.meals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var imageView = holder.image
        Picasso.get().load(list.meals[position].strMealThumb).resize(450, 350).centerCrop().into(imageView)
        holder.foodName.setText(list.meals.get(position).strMeal)
        holder.category.setText(list.meals.get(position).strCategory)
        holder.originCountry.setText(list.meals.get(position).strArea)
    }
}