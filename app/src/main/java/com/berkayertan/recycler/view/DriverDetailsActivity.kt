package com.berkayertan.recycler.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.berkayertan.recycler.databinding.ActivityDriverDetailsBinding

class DriverDetailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDriverDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDriverDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

}