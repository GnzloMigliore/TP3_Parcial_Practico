package myapp.ort.edu.parcial_practico_tp3.data.network

import myapp.ort.edu.parcial_practico_tp3.data.model.Personajes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PersonajesApi {
    @GET("api/character")
    suspend fun getPersonajes(): Response<myapp.ort.edu.parcial_practico_tp3.data.model.Respuesta>

    @GET("api/character/{ids}")
    suspend fun getPersonajesFav(@Path("ids") ids: String): Response<List<Personajes>>

    @GET("api/character/{ids}")
    suspend fun getPersonaje(@Path("ids") ids: String): Response<Personajes>
}