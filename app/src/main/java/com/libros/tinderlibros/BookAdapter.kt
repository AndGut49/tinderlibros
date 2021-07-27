package com.libros.tinderlibros

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class BookAdapter(private val books: ArrayList<Book>, context: Context) : RecyclerView.Adapter<BookAdapter.BookHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BookHolder(layoutInflater.inflate(R.layout.item_book, parent, false))
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        val item = books.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int  = books.size


    class BookHolder(v: View) : RecyclerView.ViewHolder(v){
        private val titleBook = itemView.findViewById(R.id.tv_title) as TextView
        private val coverBook = itemView.findViewById(R.id.iv_cover) as ImageView

        fun bind(book: Book) {
            titleBook.text = book.name
            Picasso.get().load(book.urlImage).into(coverBook)
        }
    }
}