package myapp.ort.edu.parcial_practico_tp3.data.model

import com.google.gson.annotations.SerializedName

data class Origin (
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)