package com.chatwise.assignment.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chatwise.assignment.R
//import com.chatwise.assignment.adapter.ProductAdapter
import com.chatwise.assignment.adapter.RecycleViewAdapter
import com.chatwise.assignment.data.Product
import com.chatwise.assignment.data.ProductsRepository
import com.chatwise.assignment.data.ProductsRepositoryImpl
import com.chatwise.assignment.data.products
import com.chatwise.assignment.utils.RetrofitInstance
import retrofit2.Call

import com.google.gson.Gson
import retrofit2.Callback
import retrofit2.Response


class productDisplay : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: RecycleViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_product_display, container, false)
        recyclerView = view.findViewById(R.id.recyclerDashboard)
        val retrofitData= RetrofitInstance.api.getProductsList()
        retrofitData.enqueue(object : Callback<products?> {
            override fun onResponse(call: Call<products?>, response: Response<products?>) {
                // if api call is success,then use the data of API and show in android app
                val responseBody=response.body()
                val productList= responseBody?.products!!

                productAdapter = RecycleViewAdapter(productList)
                recyclerView.adapter = productAdapter
                recyclerView.setVisibility(View.VISIBLE)

                recyclerView.layoutManager = LinearLayoutManager(activity)
            }

                override fun onFailure(call: Call<products?>, t: Throwable) {
            // if api call is fails

            Log.d("productDisplay","OnFailure"+t.message)

        }
    })


        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            productDisplay().apply {
            }
    }
}