package myapp.ort.edu.parcial_practico_tp3.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import myapp.ort.edu.parcial_practico_tp3.R
import myapp.ort.edu.parcial_practico_tp3.adapters.PersonajesAdapter
import myapp.ort.edu.parcial_practico_tp3.data.model.Personajes

class FragmentFavoritos : Fragment() {
    private lateinit var v: View
    private lateinit var nombre: String
    private lateinit var tituloFavoritos: TextView
    private lateinit var viewModel: FragmentFavoritosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_favoritos, container, false)
        tituloFavoritos = v.findViewById(R.id.textViewTituloFavoritos)
        val sharedPreferences =
            activity?.getSharedPreferences("LOGIN_DATA", AppCompatActivity.MODE_PRIVATE)
        nombre = sharedPreferences?.getString("usuario", "").toString()
        tituloFavoritos.setText(getResources().getString(R.string.fav_titulo, nombre))
        return v
    }

    override fun onStart() {
        super.onStart()
        viewModel = ViewModelProvider(this).get(FragmentFavoritosViewModel::class.java)
        viewModel.personajes.observe(this, Observer {
            initRecycler(it)
        })

    }

    fun initRecycler(personajes: List<Personajes>){
        val recyclerView = v.findViewById<RecyclerView>(R.id.recyclerViewPersonajes)
        val manager = GridLayoutManager(this.context, 2)
        recyclerView.setLayoutManager(manager)
        recyclerView.setHasFixedSize(true)
        val adapter = PersonajesAdapter(personajes)
        recyclerView.adapter = adapter
    }
    companion object {

        fun newInstance(): FragmentFavoritos {
            return FragmentFavoritos()
        }

    }
}