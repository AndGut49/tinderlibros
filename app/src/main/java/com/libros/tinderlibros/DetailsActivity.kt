package com.libros.tinderlibros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {

    lateinit var titleBook : String
    lateinit var urlBook: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val title = findViewById<TextView>(R.id.title)
        val image = findViewById<ImageView>(R.id.iv_cover)

        titleBook = intent.getStringExtra("title").toString()
        urlBook = intent.getStringExtra("url").toString()

        Log.e("error", titleBook + urlBook)
        title.text = titleBook.toString()

        Picasso.get().load(urlBook).into(image)

    }
}