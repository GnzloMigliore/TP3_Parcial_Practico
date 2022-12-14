package myapp.ort.edu.parcial_practico_tp3.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import myapp.ort.edu.parcial_practico_tp3.core.RetrofitHelper
import myapp.ort.edu.parcial_practico_tp3.data.model.Personajes
import myapp.ort.edu.parcial_practico_tp3.data.model.Respuesta

class PersonajesService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getPersonajes(): Respuesta {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(PersonajesApi::class.java).getPersonajes()
            (response.body() ?: null) as Respuesta
        }
    }

    suspend fun getPersonaje(id: String): Personajes {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(PersonajesApi::class.java).getPersonaje(id)
            (response.body() ?: null) as Personajes
        }
    }

    suspend fun getPersonajesFav(ids: String): List<Personajes> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(PersonajesApi::class.java).getPersonajesFav(ids)
            response.body() ?: emptyList()


        }
    }
}