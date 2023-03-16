package com.berkayertan.recycler


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.berkayertan.recycler.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val fFragment = FirstFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.drivers -> setCurrentFragment(fFragment)





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