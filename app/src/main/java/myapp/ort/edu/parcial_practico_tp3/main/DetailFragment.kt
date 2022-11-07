package myapp.ort.edu.parcial_practico_tp3.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import myapp.ort.edu.parcial_practico_tp3.R

class DetailFragment : Fragment() {
  lateinit var nombre : TextView
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
         nombre = v.findViewById(R.id.textView2)
        return v
    }

    override fun onStart() {
        super.onStart()
        val sharedPreferences =
            activity?.getSharedPreferences("ID_DATA", AppCompatActivity.MODE_PRIVATE)
            nombre.text = sharedPreferences?.getString("id","")
    }
}