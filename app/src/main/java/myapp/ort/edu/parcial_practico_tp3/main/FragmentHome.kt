package myapp.ort.edu.parcial_practico_tp3.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import myapp.ort.edu.parcial_practico_tp3.R
import myapp.ort.edu.parcial_practico_tp3.adapters.PersonajesAdapter
import myapp.ort.edu.parcial_practico_tp3.data.model.Personajes

class FragmentHome : Fragment() {
    private lateinit var v: View
    private lateinit var sVBuscador: SearchView
    lateinit var card: LinearLayout
    lateinit var id: TextView
    companion object {
        fun newInstance() = FragmentHome()
    }

    private lateinit var viewModel: FragmentHomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_home, container, false)

        sVBuscador = v.findViewById(R.id.searchViewHome)
        val sharedPreferences =
            activity?.getSharedPreferences("SETTINGS_DATA", AppCompatActivity.MODE_PRIVATE)
        var isVisible = sharedPreferences?.getBoolean("buscador", false) == true

        if(isVisible){
            sVBuscador.visibility = View.VISIBLE
        } else {
            sVBuscador.visibility = View.GONE
        }

        return v
    }

    override fun onStart() {
        super.onStart()
        viewModel = ViewModelProvider(this).get(FragmentHomeViewModel::class.java)
        viewModel.personajes.observe(this, Observer {
            initRecycler(it)
        })
    }
    fun initRecycler(personajes: List<Personajes>){
        val recyclerView = v.findViewById<RecyclerView>(R.id.recyclerViewPersonajes)
        val manager = GridLayoutManager(this.context, 2)
        recyclerView.setLayoutManager(manager)
        recyclerView.setHasFixedSize(true)
        val adapter = PersonajesAdapter(personajes,v, this)
        recyclerView.adapter = adapter
    }
    fun changeFragment(){
        (activity as MainActivity?)?.replaceFragment(DetailFragment.newInstance())
    }
}