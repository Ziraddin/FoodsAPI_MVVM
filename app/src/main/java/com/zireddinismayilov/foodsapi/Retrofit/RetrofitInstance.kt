package com.zireddinismayilov.foodsapi.Retrofit

import com.zireddinismayilov.foodsapi.API.FoodAPI
import com.zireddinismayilov.foodsapi.Constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val instance = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(FoodAPI::class.java)
}