package com.example.polihack

import android.graphics.Paint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {
    var imageView: ImageView? = null
    var loading: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        imageView = findViewById(R.id.imageView);
        loading = findViewById(R.id.loading)
        val textview = findViewById<TextView>(R.id.create_acc_text)
        textview.paintFlags = textview.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        // Adding the gif here using glide library
        Glide.with(this).load(R.drawable.heart_video).into(imageView);
        Glide.with(this).load(R.drawable.loading).into(loading);
    }
}