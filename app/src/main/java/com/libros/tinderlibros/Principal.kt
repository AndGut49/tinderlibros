package com.libros.tinderlibros

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Principal : AppCompatActivity() {

    //Recyclerview elements
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private lateinit var mRvBooks : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        mRvBooks = findViewById(R.id.rv_books)
        mLinearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        mRvBooks.layoutManager = mLinearLayoutManager


    }
}