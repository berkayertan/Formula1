package com.berkayertan.recycler.view


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.berkayertan.recycler.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment
import com.berkayertan.recycler.R

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding : ActivityMainBinding
    private val fFragment = FirstFragment()
    private val sFragment = SecondFragment()
    private val driverstand = StandingFragment()
    private val constructorstand = ConstructorStandingFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navview.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.stand-> setCurrentFragment(driverstand)
                R.id.constructor-> setCurrentFragment(constructorstand)
            }
            binding.drawerLayout.closeDrawers()
            true
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.drivers -> setCurrentFragment(fFragment)
                R.id.teams -> setCurrentFragment(sFragment)
                //R.id.standings -> setCurrentFragment(driverstand)
                //R.id.calendar -> setCurrentFragment(constructorstand)
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }



    fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }

    }
}