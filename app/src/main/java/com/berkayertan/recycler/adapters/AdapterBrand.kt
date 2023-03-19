package com.berkayertan.recycler.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.berkayertan.recycler.DriverDetailsActivity
import com.berkayertan.recycler.data.BrandData
import com.berkayertan.recycler.databinding.BrandBinding

class AdapterBrand(private val Brands : List<BrandData>) : RecyclerView.Adapter<AdapterBrand.ViewHolder> () {
    class ViewHolder(private val binding: BrandBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bing(teams: BrandData) {
            binding.brandImage.setImageResource(teams.brandImage)
            binding.brandNameTextView.text = teams.brandName
            binding.principleNameTextView.text = teams.principleName

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, DriverDetailsActivity::class.java)
                binding.root.context.startActivity(intent)
            }
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BrandBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bing(Brands[position])
    }

    override fun getItemCount(): Int {
        return Brands.size
    }

}