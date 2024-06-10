package com.example.youtube_design.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube_design.databinding.ListItemBinding

class MyAdapter(private val youtubeContainsList :ArrayList<YoutubeClass>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
       return youtubeContainsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = youtubeContainsList.getOrNull(position)
        currentItem?.let {
            holder.bind(it)
        }
    }

    class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(currentItem: YoutubeClass){
            binding.titleImage.setImageResource(currentItem.titleImageView)

            binding.subTitle.text = currentItem.subHeading

            binding.youtubeClass = currentItem
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }

    }

}