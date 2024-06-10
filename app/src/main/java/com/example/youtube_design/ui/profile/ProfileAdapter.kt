package com.example.youtube_design.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube_design.databinding.SettingCardWithoutIconBinding

class ProfileAdapter(private val iconList :ArrayList<ProfileClass>) :
    RecyclerView.Adapter<ProfileAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return iconList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = iconList.getOrNull(position)
        currentItem?.let {
            holder.bind(it)
        }
    }

    class MyViewHolder(private val binding: SettingCardWithoutIconBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(currentItem: ProfileClass){
            binding.iconImage.setImageResource(currentItem.iconImage)
            binding.settingTitle.text = currentItem.title

        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SettingCardWithoutIconBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }

    }

}