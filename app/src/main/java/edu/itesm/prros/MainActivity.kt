//Diego Ramírez Levy - A01367771
//Aldo Fernando Ortíz Mejía - A01654725

package edu.itesm.prros

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import edu.itesm.prros.adapter.LibrosAdapter
import edu.itesm.prros.databinding.ActivityMainBinding
import edu.itesm.prros.mvvm.LibrosViewModel
import edu.itesm.prros.response.Book


class MainActivity : AppCompatActivity(){
    private lateinit var adapter: LibrosAdapter
    private lateinit var binding: ActivityMainBinding
    private  lateinit var viewModel: LibrosViewModel
    private val libros = mutableListOf<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        initViewModel()
        viewModel.libroAPICall()
    }

    @SuppressLint("NotifyDatasetChanged")
    private fun initViewModel(){
        viewModel = ViewModelProvider(this).get(LibrosViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this,{
            if (it != null){
                Log.v("Libros", it.results.books.toString())
                adapter.setLibro(it.results.books)
                adapter.notifyDataSetChanged()
            }
        })
    }
    private fun initAdapter(){
        adapter = LibrosAdapter(libros)
        binding.listaLibros.layoutManager = LinearLayoutManager(this)
        binding.listaLibros.adapter = adapter

    }
}