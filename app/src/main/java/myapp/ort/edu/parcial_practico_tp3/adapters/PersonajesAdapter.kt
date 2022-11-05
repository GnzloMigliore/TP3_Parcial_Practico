package myapp.ort.edu.parcial_practico_tp3.adapters

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import myapp.ort.edu.parcial_practico_tp3.R
import myapp.ort.edu.parcial_practico_tp3.data.model.Personajes
import java.net.URL


class PersonajesAdapter(val personajes: List<Personajes>):RecyclerView.Adapter<PersonajesAdapter.PersonajesHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajesHolder {
        val layout = LayoutInflater.from(parent.context)
        return PersonajesHolder(layout.inflate(R.layout.item_personajes, parent, false))
    }

    override fun onBindViewHolder(holder: PersonajesHolder, position: Int) {
            holder.render(personajes[position])
    }

    override fun getItemCount(): Int {
        return personajes.size
    }
    class PersonajesHolder(val view: View):RecyclerView.ViewHolder(view){
        lateinit var title1: TextView


        fun render(personaje: Personajes){
            title1 = view.findViewById(R.id.text1Card1);
            title1.text = personaje.name
        }
    }
}