package myapp.ort.edu.parcial_practico_tp3.data.model


import com.google.gson.annotations.SerializedName

data class Respuesta (
    @SerializedName("info") val info : Info,
    @SerializedName("results") val results : List<Personajes>
)

data class RespuestaPorIds (
    @SerializedName("") val results : List<Personajes>
)