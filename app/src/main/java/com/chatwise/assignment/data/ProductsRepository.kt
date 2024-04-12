package com.chatwise.assignment.data

import com.chatwise.assignment.data.Product
import retrofit2.Call

interface ProductsRepository {
    suspend fun getProductsList(): Call<products>
}
