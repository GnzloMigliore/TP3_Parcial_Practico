package myapp.ort.edu.parcial_practico_tp3.main.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import myapp.ort.edu.parcial_practico_tp3.R
import myapp.ort.edu.parcial_practico_tp3.main.MainActivity

class LoginFragment : Fragment() {

    private lateinit var txtOlvido: TextView
    private lateinit var btnContinuar: Button
    private lateinit var eTUsuario: EditText
    private lateinit var eTPassword: EditText
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
        eTUsuario = view.findViewById(R.id.editTextUsuario)
        eTPassword = view.findViewById(R.id.editTextPassword)


        txtOlvido.setOnClickListener {
            (context as LoginActivity).changeFragment(OlvidoFragment.newInstance())
        }

        btnContinuar.setOnClickListener {
            val usuario = eTUsuario.text.toString()
            val password = eTPassword.text.toString()
            if (usuario.isNotEmpty() && password.isNotEmpty()) {
                val sharedPreferences =
                    activity?.getSharedPreferences("LOGIN_DATA", AppCompatActivity.MODE_PRIVATE)
                val loginData = sharedPreferences?.edit()
                loginData?.putString("usuario", usuario)
                loginData?.putString("password", password)
                loginData?.apply()
                startActivity(Intent(activity, MainActivity::class.java))
            } else {
                Toast.makeText(
                    activity?.applicationContext,
                    "No completaste con tus datos!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }

        return view
    }


    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }
}