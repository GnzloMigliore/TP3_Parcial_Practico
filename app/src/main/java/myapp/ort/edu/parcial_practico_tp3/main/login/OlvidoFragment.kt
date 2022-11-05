package myapp.ort.edu.parcial_practico_tp3.main.login

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import myapp.ort.edu.parcial_practico_tp3.R

class OlvidoFragment : Fragment() {
    private lateinit var btnRecuperar: Button
    private lateinit var eTEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_olvido, container, false)
        eTEmail = view.findViewById(R.id.editTextEmail)
        btnRecuperar = view.findViewById(R.id.buttonRecuperar)

        btnRecuperar.setOnClickListener {
            val email = eTEmail.text.toString()
            if (email.isNotEmpty()) {
                if (isEmailValid(email)) {
                    Toast.makeText(activity, "¡Email enviado!", Toast.LENGTH_SHORT)
                        .show()
                    Handler(Looper.getMainLooper()).postDelayed(
                        {
                            (context as LoginActivity).changeFragment(LoginFragment.newInstance())
                        }, 2000
                    )
                } else {
                    Toast.makeText(activity, "Ingrese un email valido", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(activity, "Ingrese su email", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        return view
    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    companion object {
        fun newInstance(): OlvidoFragment {
            return OlvidoFragment()
        }
    }
}