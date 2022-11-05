package myapp.ort.edu.parcial_practico_tp3.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import myapp.ort.edu.parcial_practico_tp3.R

class FragmentFavoritos : Fragment() {
   private lateinit var nombre: String
   private lateinit var tituloFavoritos: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favoritos, container, false)
        tituloFavoritos = view.findViewById(R.id.textViewTituloFavoritos)
        val sharedPreferences =
            activity?.getSharedPreferences("LOGIN_DATA", AppCompatActivity.MODE_PRIVATE)
        nombre = sharedPreferences?.getString("usuario", "").toString()
        tituloFavoritos.setText(getResources().getString(R.string.fav_titulo, nombre))
        return view
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentFavoritos().apply {
                arguments = Bundle().apply {

                }
            }
    }
}