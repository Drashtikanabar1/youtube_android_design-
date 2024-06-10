package com.example.youtube_design.ui.Subscription

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube_design.databinding.SubscriptionAllCardBinding
import com.example.youtube_design.databinding.SubscriptionCardBinding


class SubscriptionAdapter(private val items: List<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_CHANNEL = 0
        private const val TYPE_ALL = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is SubscriptionData) TYPE_CHANNEL else TYPE_ALL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_CHANNEL) {
            val binding = SubscriptionCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ChannelViewHolder(binding)
        } else {
            val binding = SubscriptionAllCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            AllViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_CHANNEL) {
            val channel = items[position] as SubscriptionData
            (holder as ChannelViewHolder).bind(channel)
        } else {
            // No binding needed for "All" item
        }
    }

    override fun getItemCount() = items.size

    class ChannelViewHolder(private val binding: SubscriptionCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(channel: SubscriptionData) {
            binding.channelName.text = channel.name
            binding.channelImage.setImageResource(channel.imageResId)
            // Hide or show the blue dot based on some condition
            binding.blueDot.visibility = if (channel.showDot) View.VISIBLE else View.GONE
        }
    }

    class AllViewHolder(binding: SubscriptionAllCardBinding) : RecyclerView.ViewHolder(binding.root)
}
