package myapp.ort.edu.parcial_practico_tp3.core

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {
    var gson = GsonBuilder()
        .setLenient()
        .create()

    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}