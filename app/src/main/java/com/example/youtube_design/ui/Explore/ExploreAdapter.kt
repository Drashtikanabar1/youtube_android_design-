package com.example.youtube_design.ui.Explore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube_design.databinding.ButtonLayoutBinding


class ExploreAdapter(private val exploreList :ArrayList<ExploreClass>) :
    RecyclerView.Adapter<ExploreAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return exploreList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = exploreList.getOrNull(position)
        currentItem?.let {
            holder.bind(it)
        }
    }

    class MyViewHolder(private val binding: ButtonLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(currentItem: ExploreClass){
            binding.backgroundImage.setImageResource(currentItem.backgroundImage)
            binding.iconImage.setImageResource(currentItem.iconImage)
            binding.title.text = currentItem.title

        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ButtonLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }

    }

}