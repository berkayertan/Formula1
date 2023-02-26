package com.berkayertan.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.berkayertan.recycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val drivers = listOf(
           Model("Lewis Hamilton", "Mercedes"),
           Model("Max Verstappen", "Red Bull Racing"),
           Model("Lando Norris", "McLaren"),
           Model("Valtteri Bottas", "Mercedes"),
           Model("Charles Leclerc", "Ferrari"),
           Model("Sergio Perez", "Red Bull Racing"),
           Model("Carlos Sainz Jr.", "Ferrari"),
           Model("Daniel Ricciardo", "McLaren"),
           Model("Pierre Gasly", "AlphaTauri"),
            Model("Esteban Ocon", "Alpine")
        )

        val adapter = Adapter(drivers)
        binding.rcview.adapter = adapter
        binding.rcview.layoutManager = LinearLayoutManager(this)
    }
}