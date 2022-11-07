package myapp.ort.edu.parcial_practico_tp3.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import myapp.ort.edu.parcial_practico_tp3.R
import myapp.ort.edu.parcial_practico_tp3.data.model.Personajes
import myapp.ort.edu.parcial_practico_tp3.data.network.PersonajesService

class DetailFragment : Fragment() {
    private lateinit var tVName: TextView
    private lateinit var tVStatus: TextView
    private lateinit var tVEspecie: TextView
    private lateinit var tVOrigen: TextView
    private lateinit var imgCharacter: ImageView
    private lateinit var imgStatus: ImageView
    private lateinit var imgAddFav: ImageView
    private lateinit var v: View

    companion object {
        fun newInstance() = DetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_detail, container, false)
        tVName = v.findViewById(R.id.textName)
        tVStatus = v.findViewById(R.id.textStatus)
        tVOrigen = v.findViewById(R.id.textOrigen)
        tVEspecie = v.findViewById(R.id.textEspecie)
        imgCharacter = v.findViewById(R.id.imageCharacter)
        imgStatus = v.findViewById(R.id.imageStatus)
        imgAddFav = v.findViewById(R.id.imageViewAddFav)
        val sharedPreferences =
            activity?.getSharedPreferences("SETTINGS_DATA", AppCompatActivity.MODE_PRIVATE)
        val favoritos = sharedPreferences?.getBoolean("favoritos", true) == true
        if(!favoritos){
            imgAddFav.visibility = View.GONE
        }
        imgAddFav.setOnClickListener {
            Toast.makeText(activity, getString(R.string.card_add_fav), Toast.LENGTH_SHORT)
                .show()
        }
        return v
    }

    override fun onStart() {
        super.onStart()
        val sharedPreferences =
            activity?.getSharedPreferences("ID_DATA", AppCompatActivity.MODE_PRIVATE)
        val id = sharedPreferences?.getString("id", "")
        tVName.text = id

        lifecycleScope.launch {
            val result = getpersonaje(id.toString())
            tVName.text = result.name
            tVStatus.text = result.status
            tVOrigen.text = result.origin.name
            tVEspecie.text = result.species
            Picasso.with(v.context).load(result.image).into(imgCharacter)
            if (tVStatus.text != "Alive") {
                imgStatus.setImageResource(R.drawable.ic_baseline_circle_24_red)
            }
        }
    }

    private suspend fun getpersonaje(id: String): Personajes {
        val apipost = PersonajesService()
        val response: Personajes = apipost.getPersonaje(id)
        return response
    }
}