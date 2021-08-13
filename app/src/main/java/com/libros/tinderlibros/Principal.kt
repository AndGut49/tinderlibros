package com.libros.tinderlibros

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView

class Principal : AppCompatActivity(), View.OnClickListener {

    //ViewPager
    private lateinit var viewPager : ViewPager
    private lateinit var pagerAdapter: BooksPagerAdapter

    //Buttons
    lateinit var mBtnPrevious: ImageView
    private lateinit var mBtnRead: ImageView
    private lateinit var mBtnNext: ImageView
    private lateinit var mBtnSearch: Button

    //toggle
    lateinit var  toggle:ActionBarDrawerToggle

    val books = arrayListOf<Book>(Book("El principito", "https://ia800307.us.archive.org/view_archive.php?archive=/0/items/olcovers229/olcovers229-L.zip&file=2295636-L.jpg"),
        Book("It", "https://covers.openlibrary.org/b/id/10326484-L.jpg"),
                Book("Strange Animals", "https://covers.openlibrary.org/b/id/8340872-L.jpg"),
                Book("Electric dreams", "https://covers.openlibrary.org/b/id/10112227-L.jpg"),
                Book("Atlas cloud", "https://covers.openlibrary.org/b/id/8497190-L.jpg"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        var mBtnMenu: Button =findViewById(R.id.hamburger)
        registerForContextMenu(mBtnMenu)
        mBtnMenu.setOnClickListener(this)

        setUpViewPager()
        setUpButtons()
    }

    override fun onClick(v: View?){
        var popMenu = PopupMenu(this,v)
        popMenu.menuInflater.inflate(R.menu.nav_drawer_menu, popMenu.menu)
        popMenu.setOnMenuItemClickListener { item ->
            when(item.itemId){
                R.id.itemConfig->{
                    Toast.makeText(this,"Opción no implementada",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.itemClose->{
                    Toast.makeText(this,"Opción no implementada",Toast.LENGTH_SHORT).show()
                    true
                }
            }
            false
        }
        popMenu.show()
    }

    private fun setUpButtons() {

        mBtnPrevious = findViewById(R.id.previous)
        mBtnRead = findViewById(R.id.read)
        mBtnNext = findViewById(R.id.next)
        mBtnSearch = findViewById(R.id.search)


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
            MyCustomDialog().show(supportFragmentManager,"MyCustomDialog")
        }
    }


    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        var inflater = menuInflater
        inflater.inflate(R.menu.nav_drawer_menu, menu)
    }

    private fun setUpViewPager() {
        viewPager = findViewById(R.id.vp_books)
        pagerAdapter = BooksPagerAdapter(supportFragmentManager, books)
        viewPager.adapter = pagerAdapter
    }

}