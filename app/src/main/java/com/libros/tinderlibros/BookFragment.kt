package com.libros.tinderlibros

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso

class BookFragment : Fragment()  {

    lateinit var titleBook :String
    lateinit var urlBook: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        val view = inflater.inflate(R.layout.item_book,container, false)
        val title = view.findViewById<TextView>(R.id.tv_title)
        val image = view.findViewById<ImageView>(R.id.iv_cover)

        val args = arguments
        titleBook = args?.getString("title") ?: "Titulo no disponible"
        urlBook = args!!.get("url") as String
        title.text = titleBook

        Picasso.get().load(urlBook).into(image)

        image.setOnClickListener {
            toDetailsActivity()
        }
        return view
    }

    private fun toDetailsActivity() {
        val detailsIntent = Intent(activity,DetailsActivity::class.java)
        detailsIntent.putExtra("title", titleBook)
        detailsIntent.putExtra("url", urlBook)
        startActivity(detailsIntent)
    }

    companion object {
        
        fun newInstance(book: Book) : BookFragment {
            val args = Bundle()
            args.putString("title", book.name)
            args.putString("url", book.urlImage)
            val fragment = BookFragment()
            fragment.arguments = args
            return fragment
        }
    }

}
