package com.chatwise.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.chatwise.assignment.activity.ProductDisplay
import com.chatwise.assignment.utils.connectionManager

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            if(connectionManager().checkConectivity(this)){
                var intent = Intent(this@MainActivity, ProductDisplay::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,"Internet is not Connected",Toast.LENGTH_SHORT).show()
            }
        }
    }
}


