package edu.itesm.prros.response

data class Libro(val rango: Int,
                 val titulo: String,
                 val descripcion: String,
                 val img_libro: String)

data class newResponse(
    val status: String,
    val results: Libros
    )

data class Libros(
    val libros: List<Libro>
)