package myapp.ort.edu.parcial_practico_tp3.domain
import myapp.ort.edu.parcial_practico_tp3.data.PersonajesRespository
import myapp.ort.edu.parcial_practico_tp3.data.model.Personajes


class GetPersonajes {
        private val repository = PersonajesRespository()

        suspend operator fun invoke(): List<Personajes> {
            return repository.getPersonajes()
        }
}

class GetPersonajesFav {
    private val repository = PersonajesRespository()

    suspend operator fun invoke(ids:String): List<Personajes> {
        return repository.getPersonajesFav(ids)
    }
}