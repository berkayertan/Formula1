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
            Model("Charles Leclerc", "Ferrari",R.drawable.charles_leclerc),
            Model("Carlos Sainz Jr.", "Ferrari",R.drawable.carlos_sainz_jr),
            Model("Lewis Hamilton", "Mercedes",R.drawable.lewis_hamilton),
            Model("George Russel", "Mercedes",R.drawable.george_russel),
            Model("Sergio Perez", "Red Bull Racing",R.drawable.sergio_perez),
            Model("Max Verstappen", "Red Bull Racing",R.drawable.max_verstappen),
            Model("Lando Norris", "McLaren",R.drawable.lando_norris),
            Model("Oscar Piastri", "McLaren",R.drawable.oscar_piastri),
            Model("Nyck De Vries", "Alpha Tauri",R.drawable.nyck_de_vyries),
            Model("Yuki Tsunoda", "Alpha Tauri",R.drawable.yuki_tsunoda),
            Model("Valtteri Bottas", "Alfa Romeo",R.drawable.valteri_bottas),
            Model("Zhou Guanyu", "Alfa Romeo",R.drawable.zhou_guanyu),
            Model("Pierre Gasly", "Alpine",R.drawable.pierre_gasly),
            Model("Esteban Ocon", "Alpine",R.drawable.esteban_ocon),
            Model("Lance Stroll", "Aston Martin",R.drawable.lance_stroll),
            Model("Fernando Alonso", "Aston Martin",R.drawable.fernando_alonso),
            Model("Kevin Magnussen", "Haas",R.drawable.kevin_magnussen),
            Model("Nico Hulkenberg", "Haas",R.drawable.nico_hulkenberg),
            Model("Logan Sargeant", "Williams Racing",R.drawable.logan_sergeant),
            Model("Alexander Albon", "Williams Racing",R.drawable.alex_albon),
        )

        val adapter = Adapter(drivers)
        binding.rcview.adapter = adapter
        binding.rcview.layoutManager = LinearLayoutManager(this)
    }
}