package myapp.ort.edu.parcial_practico_tp3.data.network
import retrofit2.Response
import retrofit2.http.GET

interface PersonajesApi {
    @GET("api/character")
    suspend fun getPersonajes():Response<myapp.ort.edu.parcial_practico_tp3.data.model.Respuesta>
}