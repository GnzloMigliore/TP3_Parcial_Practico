package myapp.ort.edu.parcial_practico_tp3.data

import myapp.ort.edu.parcial_practico_tp3.data.model.Personajes
import myapp.ort.edu.parcial_practico_tp3.data.network.PersonajesService

class PersonajesRespository {
    private var api = PersonajesService()
    suspend fun getPersonajes(): List<Personajes> {
        val response = api.getPersonajes()
        return response.results
    }

    suspend fun getPersonajesFav(ids: String): List<Personajes> {
        val response = api.getPersonajesFav(ids)
        return response
    }

}