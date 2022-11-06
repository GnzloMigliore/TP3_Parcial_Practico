package myapp.ort.edu.parcial_practico_tp3.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import myapp.ort.edu.parcial_practico_tp3.core.RetrofitHelper
import myapp.ort.edu.parcial_practico_tp3.data.model.Personajes
import myapp.ort.edu.parcial_practico_tp3.data.model.Respuesta
import myapp.ort.edu.parcial_practico_tp3.data.model.RespuestaPorIds


class PersonajesService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getPersonajes(): Respuesta {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(PersonajesApi::class.java).getPersonajes()
            var respuesta = response.body()
            (response.body() ?: null) as Respuesta
        }
    }

    suspend fun getPersonajesFav(): List<Personajes> {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(PersonajesApi::class.java).getPersonajesFav()
            var respuesta = response.body()
            response.body() ?: emptyList()


        }
    }
}