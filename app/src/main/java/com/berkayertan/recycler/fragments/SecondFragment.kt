package com.berkayertan.recycler.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.berkayertan.recycler.R
import com.berkayertan.recycler.adapters.AdapterBrand
import com.berkayertan.recycler.data.BrandData
import com.berkayertan.recycler.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {
    private lateinit var binding : SecondFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SecondFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SecondFragmentBinding.bind(view)
        val teams = listOf(
            BrandData("Ferrari","Frédéric Vasseur", R.drawable.ferrari),
            BrandData("Mercedes","Toto Wolff", R.drawable.mercedes),
            BrandData("Red Bull Racing","Christian Horner", R.drawable.redbull),
            BrandData("McLaren","Andrea Stella", R.drawable.mclaren),
            BrandData("Alpha Tauri","Franz Tost", R.drawable.alphatauri),
            BrandData("Alfa Romeo","Alessandro Alunni Bravi", R.drawable.alfa),
            BrandData("Alpine","Otmar Szafnauer", R.drawable.alpine),
            BrandData("Aston Martin","Mike Krack", R.drawable.astonmartin),
            BrandData("Haas","Guenther Steiner", R.drawable.haas),
            BrandData("Williams Racing","James Vowles", R.drawable.williams),

        )
        val adapter = AdapterBrand(teams)
        binding.brandrcview.adapter = adapter
        binding.brandrcview.layoutManager = LinearLayoutManager(requireContext())
    }
}