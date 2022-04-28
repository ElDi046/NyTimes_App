package edu.itesm.prros.mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.itesm.prros.patterns.RetrofitSingleton
import edu.itesm.prros.response.newResponse
import edu.itesm.prros.service.LibrosAPIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LibrosViewModel: ViewModel() {
    var liveData : MutableLiveData<newResponse>
    init {
        liveData = MutableLiveData()
    }
    fun getLiveDataObserver(): MutableLiveData<newResponse>{
        return liveData
    }
    fun libroAPICall(raza:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitSingleton.getRetroFit().create(LibrosAPIService::class.java).getLibros()
            call.enqueue(object : Callback<newResponse> {
                override fun onResponse(call: Call<newResponse>, response: Response<newResponse>) {
                    Log.v("libro", response.body()?.results?.libros.toString())
                    liveData.postValue(response.body())
                }

                override fun onFailure(call: Call<newResponse>, t: Throwable) {
                    liveData.postValue(null)
                    Log.v("libro", "no results")
                }
            })
        }
    }
}