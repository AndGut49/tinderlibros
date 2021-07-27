package com.libros.tinderlibros

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class BooksPagerAdapter(fragmentManage: FragmentManager, private val books: ArrayList<Book>) : FragmentStatePagerAdapter(fragmentManage){

    private val MAX_VALUE = 200

    override fun getCount(): Int = books.size * MAX_VALUE

    override fun getItem(position: Int): Fragment {
        return BookFragment.newInstance(books[position % books.size])
    }

}