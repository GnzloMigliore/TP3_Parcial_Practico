package myapp.ort.edu.parcial_practico_tp3.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import myapp.ort.edu.parcial_practico_tp3.R
import myapp.ort.edu.parcial_practico_tp3.data.model.Personajes
import myapp.ort.edu.parcial_practico_tp3.data.network.PersonajesService

class DetailFragment : Fragment() {
  lateinit var nombre : TextView
    lateinit var alive : TextView
    lateinit var especie : TextView
    lateinit var origen : TextView
    lateinit var img : ImageView
    lateinit var v: View
    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_detail, container, false)
         nombre = v.findViewById(R.id.namedetail)
        alive = v.findViewById(R.id.textalive)
        origen = v.findViewById(R.id.textorigen)
        especie = v.findViewById(R.id.textespecie)
        img = v.findViewById(R.id.imagedetail)
        return v
    }

    override fun onStart() {
        super.onStart()
        val sharedPreferences =
            activity?.getSharedPreferences("ID_DATA", AppCompatActivity.MODE_PRIVATE)
            var id = sharedPreferences?.getString("id","")
            nombre.text = id
            var api = PersonajesService()
        lifecycleScope.launch {
            val result = getpersonaje(id.toString())
            nombre.text = result.name
            alive.text = result.status
            origen.text = result.origin.name
            especie.text = result.species
            Picasso.with(v.context).load(result.image).into(img)

        }
    }

    suspend fun getpersonaje(id: String): Personajes {
        var apipost = PersonajesService()
        val response: Personajes = apipost.getPersonaje(id)
        return response
    }



}