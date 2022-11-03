package myapp.ort.edu.parcial_practico_tp3.main.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import myapp.ort.edu.parcial_practico_tp3.R
import myapp.ort.edu.parcial_practico_tp3.main.login.LoginActivity

class SplashScreen : AppCompatActivity() {
    companion object{
        private const val SPLASH_TIME_OUT:Long = 3000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
            , SPLASH_TIME_OUT)
    }
}