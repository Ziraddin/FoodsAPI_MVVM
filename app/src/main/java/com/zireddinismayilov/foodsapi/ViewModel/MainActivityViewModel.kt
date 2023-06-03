package com.zireddinismayilov.foodsapi.ViewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zireddinismayilov.foodsapi.Model.ResultDTO
import com.zireddinismayilov.foodsapi.Retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {
    var result = MutableLiveData<ResultDTO>()

    fun getDataByName(foodName: String, context: Context) {
        RetrofitInstance.instance.getFoodByName(foodName)?.enqueue(object : Callback<ResultDTO?> {
            override fun onResponse(call: Call<ResultDTO?>, response: Response<ResultDTO?>) {
                result.postValue(response.body())
            }

            override fun onFailure(call: Call<ResultDTO?>, t: Throwable) {
                Toast.makeText(context, "Error has occured!", Toast.LENGTH_SHORT).show()
            }

        })
    }


    fun getDataByFirstLetter(foodName: String, context: Context) {
        RetrofitInstance.instance.getFoodByFirstLetter(foodName)?.enqueue(object : Callback<ResultDTO?> {
            override fun onResponse(call: Call<ResultDTO?>, response: Response<ResultDTO?>) {
                result.postValue(response.body())
            }

            override fun onFailure(call: Call<ResultDTO?>, t: Throwable) {
                Toast.makeText(context, "Error has occured!", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun getDataByCategory(categoryName: String, context: Context) {
        RetrofitInstance.instance.getFoodByCategory(categoryName)?.enqueue(object : Callback<ResultDTO?> {
            override fun onResponse(call: Call<ResultDTO?>, response: Response<ResultDTO?>) {
                result.postValue(response.body())
            }

            override fun onFailure(call: Call<ResultDTO?>, t: Throwable) {
                Toast.makeText(context, "Error has occured!", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun observeResult(): MutableLiveData<ResultDTO> {
        return result
    }
}
