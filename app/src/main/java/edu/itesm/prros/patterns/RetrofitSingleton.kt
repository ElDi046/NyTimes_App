package edu.itesm.prros.patterns

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {
    fun getRetroFit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/books/v3/lists/current/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
fun main(args: Array<String>){

}