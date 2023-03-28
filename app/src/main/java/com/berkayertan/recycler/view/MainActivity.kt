package com.berkayertan.recycler.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.berkayertan.recycler.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment
import com.berkayertan.recycler.R

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val fFragment = FirstFragment()
    private val sFragment = SecondFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.drivers -> setCurrentFragment(fFragment)
                R.id.teams -> setCurrentFragment(sFragment)

            }
            true
        }





    }
    fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }


}