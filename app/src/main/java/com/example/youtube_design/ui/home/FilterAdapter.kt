package com.example.youtube_design.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube_design.databinding.FilterCustomCardBinding
import com.example.youtube_design.FliterClass
import com.example.youtube_design.R

class  FilterAdapter(private val filterList: ArrayList<FliterClass>) :
    RecyclerView.Adapter<FilterAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return FilterAdapter.MyViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = filterList.getOrNull(position)
        currentItem?.let {
            holder.bind(it)
        }
    }

    class MyViewHolder(private val binding: FilterCustomCardBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(currentItem: FliterClass) {

            binding.filterName.text = currentItem.filterName
            if (position == 0) {
                binding.filterCard.setCardBackgroundColor(itemView.context.getColor(R.color.black))
                binding.filterName.setTextColor(itemView.context.getColor(R.color.white))
            } else {
                binding.filterCard.setCardBackgroundColor(itemView.context.getColor(R.color.navigationColor))
                binding.filterName.setTextColor(itemView.context.getColor(R.color.black))
            }
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FilterCustomCardBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }
}
