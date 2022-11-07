package myapp.ort.edu.parcial_practico_tp3.main.login

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import myapp.ort.edu.parcial_practico_tp3.R

class LoginActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val sharedPreferences =
            getSharedPreferences("SETTINGS_DATA", AppCompatActivity.MODE_PRIVATE)
        val mode = sharedPreferences?.getBoolean("nightMode", false) == true
        changeTheme(mode)
        sharedPreferences.registerOnSharedPreferenceChangeListener(this)
        val loginFragment = LoginFragment()
        changeFragment(loginFragment)
    }

    fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayoutLogin, fragment)
            commit()
        }
    }

    private fun changeTheme(mode: Boolean) {
        when (mode) {
            true -> AppCompatDelegate
                .setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            false -> AppCompatDelegate
                .setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        val changedMode: Boolean
        changedMode = sharedPreferences!!.getBoolean("nightMode", false) == true
        changeTheme(changedMode)
    }
}