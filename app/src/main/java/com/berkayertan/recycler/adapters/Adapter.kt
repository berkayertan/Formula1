package com.berkayertan.recycler.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.berkayertan.recycler.view.DriverDetailsActivity
import com.berkayertan.recycler.data.Model
import com.berkayertan.recycler.databinding.CarBinding

class Adapter(private val CarsandDrivers : List<Model>) : RecyclerView.Adapter<Adapter.ViewHolder> () {
    class ViewHolder(private val binding : CarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (carDriver: Model){

            binding.imageView.setImageResource(carDriver.driverImage)
            binding.carNameTextView.text = carDriver.carName
            binding.driverNameTextView.text = carDriver.driverName

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, DriverDetailsActivity::class.java)
                binding.root.context.startActivity(intent)
            }
        }


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(CarsandDrivers[position])
    }

    override fun getItemCount(): Int {
        return CarsandDrivers.size
    }

}