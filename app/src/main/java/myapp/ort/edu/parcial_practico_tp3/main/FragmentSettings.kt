package myapp.ort.edu.parcial_practico_tp3.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import myapp.ort.edu.parcial_practico_tp3.R

class FragmentSettings : Fragment() {
    private lateinit var tVSettNightMode: TextView
    private lateinit var tVBuscadorOnOff: TextView
    private lateinit var tVFavoritosOnOff: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        tVSettNightMode = view.findViewById(R.id.textViewSettNightMode)
        tVBuscadorOnOff = view.findViewById(R.id.textViewBuscadorOnOff)
        tVFavoritosOnOff = view.findViewById(R.id.textViewFavoritosOnOff)


        return view
    }

    companion object {

    }
}