package myapp.ort.edu.parcial_practico_tp3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import myapp.ort.edu.parcial_practico_tp3.R
import myapp.ort.edu.parcial_practico_tp3.data.model.Personajes

class PersonajesAdapter(val personajes: List<Personajes>):RecyclerView.Adapter<PersonajesAdapter.PersonajesHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajesHolder {
        val layout = LayoutInflater.from(parent.context)
        val view = PersonajesHolder(layout.inflate(R.layout.item_personajes, parent, false))
        return view
    }

    override fun onBindViewHolder(holder: PersonajesHolder, position: Int) {
        holder.render(personajes[position])
    }

    override fun getItemCount(): Int {
        return personajes.size
    }
    class PersonajesHolder(val view: View):RecyclerView.ViewHolder(view){
        lateinit var imgCard1: ImageView
        lateinit var title1: TextView
        lateinit var title2: TextView

        fun render(personaje: Personajes){

            imgCard1 = view.findViewById(R.id.imgCard1)
            title1 = view.findViewById(R.id.text1Card1);
            title1.text = personaje.name
            title2 = view.findViewById(R.id.text2Card1);
            title2.setText("Status: " + personaje.status)
            Picasso.with(view.context).load(personaje.image).into(imgCard1)
        }
    }
}