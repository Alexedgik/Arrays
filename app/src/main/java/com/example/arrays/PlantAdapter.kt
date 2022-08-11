package com.example.arrays

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arrays.databinding.PlantItemBinding

class PlantAdapter(val listener: Listener): RecyclerView.Adapter<PlantAdapter.PlantHolder> (){
    val plantList = ArrayList<Plant>()

    class PlantHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = PlantItemBinding.bind(item)
        fun bind(plant: Plant, listener: Listener) = with(binding){
            im.setImageResource(plant.imageId)
            tvTitle.text = plant.title
            itemView.setOnClickListener {
                listener.onClick(plant)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantHolder(view)
    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position], listener)
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    fun addPlant(plant: Plant){
        plantList.add(plant)
        notifyDataSetChanged()
    }

    interface Listener{
        fun onClick(plant: Plant)
    }
}