package myapp.ort.edu.parcial_practico_tp3.main.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import myapp.ort.edu.parcial_practico_tp3.R
import myapp.ort.edu.parcial_practico_tp3.main.MainActivity

class LoginFragment : Fragment() {

    private lateinit var txtOlvido: TextView
    private lateinit var btnContinuar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        txtOlvido = view.findViewById(R.id.textViewOlvidaste)
        btnContinuar = view.findViewById(R.id.buttonContinuar)

        txtOlvido.setOnClickListener{
            (context as LoginActivity).changeFragment(OlvidoFragment.newInstance())
        }

        btnContinuar.setOnClickListener{
            startActivity(Intent(activity, MainActivity::class.java))
        }

        return view
    }


    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }
}