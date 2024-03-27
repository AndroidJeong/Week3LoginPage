package com.example.week3login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val imageArray = arrayOf(
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five
        )
        val id = findViewById<TextView>(R.id.home_id)
        val age = findViewById<TextView>(R.id.home_age)
        val image = findViewById<ImageView>(R.id.home_image)

        id.text = "아이디: ${intent.getStringExtra("id")}"
        age.text = "나이: ${(20..100).random()}"

        val randomImageIndex = (imageArray.indices).random()

        image.setImageResource(imageArray[randomImageIndex])

        val btn = findViewById<Button>(R.id.home_button)

        btn.setOnClickListener {
            finish()
        }


    }
}