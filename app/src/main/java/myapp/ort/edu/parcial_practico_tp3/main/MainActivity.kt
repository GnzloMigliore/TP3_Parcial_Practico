package myapp.ort.edu.parcial_practico_tp3.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import myapp.ort.edu.parcial_practico_tp3.R

private lateinit var drawerLayout: DrawerLayout
private lateinit var toggle : ActionBarDrawerToggle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val HomeFragment = FragmentHome()
        replaceFragment(HomeFragment)
        drawerLayout = findViewById(R.id.drawer_layout_id)
        val navView : NavigationView = findViewById(R.id.navigationView)
       toggle = ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.Home -> replaceFragment(FragmentHome())
                R.id.Favs -> replaceFragment(FragmentFavoritos())
                R.id.Settings -> replaceFragment(FragmentSettings())
            }
           true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
    }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}