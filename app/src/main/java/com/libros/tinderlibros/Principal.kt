package com.libros.tinderlibros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager

class Principal : AppCompatActivity() {

//ViewPager
    private lateinit var viewPager : ViewPager
    private lateinit var pagerAdapter: BooksPagerAdapter

    //Buttons
    private lateinit var mBtnMenu: ImageView
    private lateinit var mBtnPrevious: ImageView
    private lateinit var mBtnRead: ImageView
    private lateinit var mBtnNext: ImageView
    private lateinit var mBtnSearch: ImageView


    val books = arrayListOf<Book>(Book("El principito", "https://ia800307.us.archive.org/view_archive.php?archive=/0/items/olcovers229/olcovers229-L.zip&file=2295636-L.jpg"),
        Book("It", "https://covers.openlibrary.org/b/id/10326484-L.jpg"),
                Book("Strange Animals", "https://covers.openlibrary.org/b/id/8340872-L.jpg"),
                Book("Electric dreams", "https://covers.openlibrary.org/b/id/10112227-L.jpg"),
                Book("Atlas cloud", "https://covers.openlibrary.org/b/id/8497190-L.jpg"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        setUpViewPager()
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
            val currentPosition = viewPager.currentItem
            viewPager.currentItem = currentPosition - 1
        }
        mBtnRead.setOnClickListener {
            val currentPosition = viewPager.currentItem
            Toast.makeText(this, "Te gusta ${books[currentPosition % books.size].name}", Toast.LENGTH_SHORT).show()
        }
        mBtnNext.setOnClickListener {
            val currentPosition = viewPager.currentItem
            viewPager.currentItem = currentPosition + 1
        }
        mBtnSearch.setOnClickListener {
            notProgrammedYet()
        }
    }

    private fun notProgrammedYet() {
        Toast.makeText(this,"Funcion no programada aún", Toast.LENGTH_SHORT).show()
    }

    private fun setUpViewPager() {
        viewPager = findViewById(R.id.vp_books)
        pagerAdapter = BooksPagerAdapter(supportFragmentManager, books)
        viewPager.adapter = pagerAdapter
    }
}