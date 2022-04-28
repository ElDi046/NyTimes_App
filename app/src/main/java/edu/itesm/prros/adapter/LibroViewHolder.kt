package edu.itesm.prros.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.itesm.prros.response.Book
import edu.itesm.prros.databinding.RenglonLibroBinding

class LibroViewHolder (view : View) : RecyclerView.ViewHolder(view){
    private val binding = RenglonLibroBinding.bind(view)

    fun bind(property: Book){
        val title = binding.tvTitle
        val imageView = binding.imageView
        val description = binding.tvDescription

        Glide.with(binding.root)
            .load(property.img_libro)
            .circleCrop()
            .into(imageView)

        title.text = property.titulo
        description.text = property.descripcion
    }
}
