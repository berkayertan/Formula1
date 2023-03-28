package com.berkayertan.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.berkayertan.recycler.data.StandingModel
import com.berkayertan.recycler.databinding.StandingItemsBinding

class StandingAdapter(val standingList : ArrayList<StandingModel>) : RecyclerView.Adapter<StandingAdapter.ViewHolder>() {
    class ViewHolder(private val binding : StandingItemsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(stand: StandingModel){
            binding.name.text = stand.name
            binding.position.text = stand.position.toString()
            binding.points.text = stand.points.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = StandingItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return standingList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(standingList[position])
    }

}