package myapp.ort.edu.parcial_practico_tp3.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

        val sharedPreferences =
            activity?.getSharedPreferences("SETTINGS_DATA", AppCompatActivity.MODE_PRIVATE)

        var nightMode = sharedPreferences?.getBoolean("nightMode", false) == true
        toggleNightMode(nightMode)
        var buscador = sharedPreferences?.getBoolean("buscador", false) == true
        toggleBuscador(buscador)
        var favoritos = sharedPreferences?.getBoolean("favoritos", false) == true
        toggleFavoritos(favoritos)

        tVSettNightMode.setOnClickListener {
            nightMode = sharedPreferences?.getBoolean("nightMode", false) == true
            val settingsData = sharedPreferences?.edit()
            settingsData?.putBoolean("nightMode", !nightMode)
            settingsData?.apply()
            toggleNightMode(!nightMode)
            Toast.makeText(
                activity?.applicationContext,
                "$nightMode",
                Toast.LENGTH_SHORT
            ).show()
        }

        tVBuscadorOnOff.setOnClickListener {
            buscador = sharedPreferences?.getBoolean("buscador", false) == true
            val settingsData = sharedPreferences?.edit()
            settingsData?.putBoolean("buscador", !buscador)
            settingsData?.apply()
            toggleBuscador(!buscador)
            Toast.makeText(
                activity?.applicationContext,
                "$buscador",
                Toast.LENGTH_SHORT
            ).show()
        }

        tVFavoritosOnOff.setOnClickListener {
            favoritos = sharedPreferences?.getBoolean("favoritos", false) == true
            val settingsData = sharedPreferences?.edit()
            settingsData?.putBoolean("favoritos", !favoritos)
            settingsData?.apply()
            toggleFavoritos(!favoritos)
            Toast.makeText(
                activity?.applicationContext,
                "$favoritos",
                Toast.LENGTH_SHORT
            ).show()
        }
        Toast.makeText(
            activity?.applicationContext,
            "No completaste con tus datos!",
            Toast.LENGTH_SHORT
        ).show()
        return view
    }

    private fun toggleNightMode(nightMode: Boolean) {
        if (nightMode) {
            tVSettNightMode.setText(getString(R.string.sett_day_mode))
        } else {
            tVSettNightMode.setText(getString(R.string.sett_night_mode))
        }
    }

    private fun toggleBuscador(buscador: Boolean) {
        if (buscador) {
            tVBuscadorOnOff.setText(getString(R.string.sett_buscador_off))
        } else {
            tVBuscadorOnOff.setText(getString(R.string.sett_buscador_on))
        }
    }

    private fun toggleFavoritos(favoritos: Boolean) {
        if (favoritos) {
            tVFavoritosOnOff.setText(getString(R.string.sett_favoritos_off))
        } else {
            tVFavoritosOnOff.setText(getString(R.string.sett_favoritos_on))
        }
    }

    companion object {
        fun newInstance(): FragmentSettings {
            return FragmentSettings()
                   }
            }
}
