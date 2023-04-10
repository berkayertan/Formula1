package com.berkayertan.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.berkayertan.recycler.data.ConstructorStandingModel
import com.berkayertan.recycler.databinding.ConstructorItemsBinding

class ConstructorAdapter(var constructorList: List<ConstructorStandingModel>): RecyclerView.Adapter<ConstructorAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ConstructorItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(constructor: ConstructorStandingModel) {
            binding.position.text = constructor.position.toString()
            binding.teams.text = constructor.team
            binding.points.text = constructor.points.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ConstructorItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return constructorList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(constructorList[position])
    }

    fun setData(newList: List<ConstructorStandingModel>) {
        constructorList = newList
        notifyDataSetChanged()
    }
}

