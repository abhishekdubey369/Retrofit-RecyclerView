package com.chatwise.assignment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import com.chatwise.assignment.R
import com.chatwise.assignment.fragment.productDisplay

class ProductDisplay : AppCompatActivity() {
    lateinit var drawerLayout:DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_display)

        drawerLayout = findViewById(R.id.drawerLayout)
        supportFragmentManager.beginTransaction().replace(R.id.frame, productDisplay()).addToBackStack("productDisplay").commit()
//        drawerLayout.closeDrawers()
    }
}