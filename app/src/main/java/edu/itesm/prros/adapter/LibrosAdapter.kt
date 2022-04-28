package edu.itesm.prros.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.itesm.prros.R
import edu.itesm.prros.response.Libro

class LibrosAdapter(private var libros: List<Libro>) : RecyclerView.Adapter<LibroViewHolder>() {

    fun setLibro(books: List<Libro>){
        libros = books.take(10)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.renglon_libro, parent, false )
        return LibroViewHolder(view)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libroUrl = libros[position]
        holder.bind(libroUrl)
    }

    override fun getItemCount(): Int {
        return libros.size
    }
}


