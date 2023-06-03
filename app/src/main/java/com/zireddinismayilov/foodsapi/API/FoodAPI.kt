package com.zireddinismayilov.foodsapi.API

import com.zireddinismayilov.foodsapi.Model.ResultDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodAPI {

    @GET("search.php")
    fun getFoodByFirstLetter(@Query("f") a: String): Call<ResultDTO?>?

    @GET("search.php")
    fun getFoodByName(@Query("s") s: String): Call<ResultDTO?>?

    @GET("filter.php")
    fun getFoodByCategory(@Query("c") c: String): Call<ResultDTO?>?
}