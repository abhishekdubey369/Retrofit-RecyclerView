package com.chatwise.assignment.data

data class products(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)