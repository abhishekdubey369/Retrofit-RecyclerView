package com.chatwise.assignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.chatwise.assignment.R
import com.chatwise.assignment.data.Product

class RecycleViewAdapter(val itemList: List<Product>): RecyclerView.Adapter<RecycleViewAdapter.DashboardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_items,parent,false)

        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val product = itemList[position]
        holder.bind(product)

    }

    class DashboardViewHolder(view: View):RecyclerView.ViewHolder(view){
        val productImage: ImageView = view.findViewById(R.id.Image)
        val textView: TextView = view.findViewById(R.id.Name)
        val productDescription: TextView = view.findViewById(R.id.Discription)
        val productRating:TextView = view.findViewById(R.id.rating)

        fun bind(product: Product) {
            textView.text = product.title
            productDescription.text = product.description
            productRating.text = product.rating.toString()

            productImage.load(product.thumbnail){
                crossfade(true)
                placeholder(R.drawable.baseline_broken_image_24)
                error(R.drawable.baseline_broken_image_24)
            }
        }

    }

}