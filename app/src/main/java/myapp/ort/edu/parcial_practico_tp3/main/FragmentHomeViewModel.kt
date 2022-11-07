package myapp.ort.edu.parcial_practico_tp3.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import myapp.ort.edu.parcial_practico_tp3.data.model.Personajes
import myapp.ort.edu.parcial_practico_tp3.domain.GetPersonajes

class FragmentHomeViewModel : ViewModel() {

    val personajesmodel = MutableLiveData<List<Personajes>>().apply {
        val getPersonajes = GetPersonajes()
        viewModelScope.launch {
            val result: List<Personajes> = getPersonajes()
            if (result != null) {
                value = result
            }
        }
    }
    val personajes: LiveData<List<Personajes>> = personajesmodel

}