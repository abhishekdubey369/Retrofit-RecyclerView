package com.chatwise.assignment.data

import com.chatwise.assignment.data.Product
import com.chatwise.assignment.data.Api
import retrofit2.Call
import retrofit2.HttpException
import java.io.IOException

class ProductsRepositoryImpl(
    private val api: Api
): ProductsRepository {

    override suspend fun getProductsList(): Call<products> {
        try {
            val response = api.getProductsList()
            return response
        } catch (e: IOException) {
            // Handle network error
            throw IOException("Error loading products", e)
        }
    }
}
