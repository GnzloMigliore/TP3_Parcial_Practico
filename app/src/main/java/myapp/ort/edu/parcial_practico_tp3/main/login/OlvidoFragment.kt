package myapp.ort.edu.parcial_practico_tp3.main.login

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import myapp.ort.edu.parcial_practico_tp3.R

class OlvidoFragment : Fragment() {

    private lateinit var btnRecuperar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_olvido, container, false)
        btnRecuperar = view.findViewById(R.id.buttonRecuperar)

        btnRecuperar.setOnClickListener{
            Toast.makeText(activity, "¡Email enviado!", Toast.LENGTH_SHORT)
                .show()
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    (context as LoginActivity).changeFragment(LoginFragment.newInstance())
                }
                , 2000)
        }

        return view
    }

    companion object {
        fun newInstance(): OlvidoFragment {
            return OlvidoFragment()
        }
    }
}