package com.libros.tinderlibros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Principal : AppCompatActivity() {

    //Recyclerview elements
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private lateinit var mRvBooks : RecyclerView



    //Buttons
    private lateinit var mBtnMenu: ImageView
    private lateinit var mBtnPrevious: ImageView
    private lateinit var mBtnRead: ImageView
    private lateinit var mBtnNext: ImageView
    private lateinit var mBtnSearch: ImageView


    val books = arrayListOf<Book>(Book("El principito", "https://ia800307.us.archive.org/view_archive.php?archive=/0/items/olcovers229/olcovers229-L.zip&file=2295636-L.jpg"),
        Book("It", "https://covers.openlibrary.org/b/id/10326484-L.jpg"),
                Book("Strange Animals", "https://covers.openlibrary.org/b/id/8340872-L.jpg"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        setUpRecyclerview()
        setUpButtons()
    }

    private fun setUpButtons() {
        mBtnMenu = findViewById(R.id.hamburger)
        mBtnPrevious = findViewById(R.id.previous)
        mBtnRead = findViewById(R.id.read)
        mBtnNext = findViewById(R.id.next)
        mBtnSearch = findViewById(R.id.search)

        mBtnMenu.setOnClickListener {
            notProgrammedYet()
        }
        mBtnPrevious.setOnClickListener {
            mRvBooks.layoutManager?.scrollToPosition(mLinearLayoutManager.findLastVisibleItemPosition() - 1)
        }
        mBtnRead.setOnClickListener {
            notProgrammedYet()
        }
        mBtnNext.setOnClickListener {
            mRvBooks.layoutManager?.scrollToPosition(mLinearLayoutManager.findLastVisibleItemPosition() + 1)
        }
        mBtnSearch.setOnClickListener {
            notProgrammedYet()
        }
    }

    private fun notProgrammedYet() {
        Toast.makeText(this,"Funcion no programada aún", Toast.LENGTH_SHORT).show()
    }

    private fun setUpRecyclerview() {
        mRvBooks = findViewById(R.id.rv_books)
        mLinearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        val mAdapter = BookAdapter(books, this)
        mRvBooks.layoutManager = mLinearLayoutManager
        mRvBooks.adapter = mAdapter
    }
}