package edu.itesm.prros.service

import edu.itesm.prros.response.newResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface LibrosAPIService {
    @GET("hardcover-fiction.json?api-key=FQngXMrxO7lDeQFGIgdnEqa0tm3ciIrp")
    fun getLibros():
            Call<newResponse>
}