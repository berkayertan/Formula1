package com.berkayertan.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.berkayertan.recycler.data.RaceResultsModel
import com.berkayertan.recycler.databinding.RaceResultItemsBinding

class RaceResultAdapter(var raceResultList: List<RaceResultsModel>):RecyclerView.Adapter<RaceResultAdapter.ViewHolder>() {
    class ViewHolder(private val binding: RaceResultItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(raceResult: RaceResultsModel) {
            binding.gp.text = raceResult.gp
            binding.date.text = raceResult.date
            binding.name.text = raceResult.name_winner
            binding.surname.text = raceResult.surname_winner
            binding.team.text = raceResult.team_winner

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RaceResultItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return raceResultList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(raceResultList[position])
    }

    fun setData(newList: List<RaceResultsModel>) {
        raceResultList = newList
        notifyDataSetChanged()
    }
}
