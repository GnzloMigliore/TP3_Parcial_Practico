package myapp.ort.edu.parcial_practico_tp3.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
        }

        tVBuscadorOnOff.setOnClickListener {
            buscador = sharedPreferences?.getBoolean("buscador", false) == true
            val settingsData = sharedPreferences?.edit()
            settingsData?.putBoolean("buscador", !buscador)
            settingsData?.apply()
            toggleBuscador(!buscador)
        }

        tVFavoritosOnOff.setOnClickListener {
            favoritos = sharedPreferences?.getBoolean("favoritos", false) == true
            val settingsData = sharedPreferences?.edit()
            settingsData?.putBoolean("favoritos", !favoritos)
            settingsData?.apply()
            toggleFavoritos(!favoritos)
        }
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
            tVBuscadorOnOff.setText(getString(R.string.sett_buscador_on))
        } else {
            tVBuscadorOnOff.setText(getString(R.string.sett_buscador_off))
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
