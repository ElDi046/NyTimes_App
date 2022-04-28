package edu.itesm.prros.response

data class Book(val rango: Int,
                 val titulo: String,
                 val descripcion: String,
                 val img_libro: String)

data class newResponse(
    val status: String,
    val results: Books
    )

data class Books(
    val books: List<Book>
)