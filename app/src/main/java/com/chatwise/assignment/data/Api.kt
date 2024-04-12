package com.chatwise.assignment.data

import retrofit2.http.GET
import com.chatwise.assignment.data.products
import retrofit2.Call

interface Api {

    @GET("products")
    fun getProductsList(): Call<products>

    companion object {
        const val BASE_URL = "https://dummyjson.com/"
    }

}