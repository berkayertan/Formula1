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
            Model("Charles Leclerc", "Ferrari"),
            Model("Carlos Sainz Jr.", "Ferrari"),
            Model("Lewis Hamilton", "Mercedes"),
            Model("George Russel", "Mercedes"),
            Model("Sergio Perez", "Red Bull Racing"),
            Model("Max Verstappen", "Red Bull Racing"),
            Model("Lando Norris", "McLaren"),
            Model("Oscar Piastri", "McLaren"),
            Model("Nyck De Vries", "Alpha Tauri"),
            Model("Yuki Tsunoda", "Alpha Tauri"),
            Model("Valtteri Bottas", "Alfa Romeo"),
            Model("Zhou Guanyu", "Alfa Romeo"),
            Model("Pierre Gasly", "Alpine"),
            Model("Esteban Ocon", "Alpine"),
            Model("Lance Stroll", "Aston Martin"),
            Model("Fernando Alonso", "Aston Martin"),
            Model("Kevin Magnussen", "Haas"),
            Model("Nico Hulkenberg", "Haas"),
            Model("Logan Sargeant", "Williams Racing"),
            Model("Alexander Albon", "Williams Racing"),
        )

        val adapter = Adapter(drivers)
        binding.rcview.adapter = adapter
        binding.rcview.layoutManager = LinearLayoutManager(this)
    }
}