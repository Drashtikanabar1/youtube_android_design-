package com.example.youtube_design.ui.Subscription

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtube_design.R
import com.example.youtube_design.databinding.FragmentHomeBinding
import com.example.youtube_design.databinding.FragmentSubscriptionBinding
import com.example.youtube_design.ui.home.MyAdapter
import com.example.youtube_design.ui.home.YoutubeClass

class SubscriptionFragment : Fragment() {


    companion object {
        fun newInstance() = SubscriptionFragment()
    }

    private var _binding: FragmentSubscriptionBinding? = null
    private val binding get() = _binding!!
    lateinit var imageId :Array<Int>

    lateinit var subHeading :Array<String>
    lateinit var viewCount :Array<String>
    lateinit var time :Array<String>
    private lateinit var newArrayList: ArrayList<SubscriptionData>
    private lateinit var videoListArrayList: ArrayList<YoutubeClass>
    private lateinit var subscriptionImageId: Array<Int>
    private lateinit var heading: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSubscriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageId  = arrayOf(
            R.drawable.image_a,
            R.drawable.image_b,
            R.drawable.image_c
        )

        heading = arrayOf(
            "Build it in Figma: Create a Design System — Foundation",
            "Figma Tutorial : Device Frames and Scrolling",
            "Build it in Figma: Create a Design System — owners",
        )
        subHeading = arrayOf(
            "Figma",
            "Figma Tutorial ",
            "subHeading",
        )
        viewCount = arrayOf(
            "1M",
            "44k",
            "54k",
        )
        time = arrayOf(
            "1 month ago",
            "2 month ago",
            "3 month ago",
        )
        subscriptionImageId = arrayOf(
            R.drawable.figma,
            R.drawable.figma,
            R.drawable.figma,
            R.drawable.figma
        )

        heading = arrayOf(
            "Technical",
            "Netflix",
            "Marvel Stu.",
            "CharliMarie"
        )




        binding.verticalView.layoutManager = LinearLayoutManager(context)
        binding.verticalView.setHasFixedSize(true)
        videoListArrayList = arrayListOf<YoutubeClass>()
        getVideoData()
        binding.subscriptionHorizontal.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.subscriptionHorizontal.setHasFixedSize(true)

        newArrayList = arrayListOf<SubscriptionData>()
        getUserData()
    }
    private fun getVideoData(){

        for(i in imageId.indices){
            val youtubeData = YoutubeClass(imageId[i],heading[i],subHeading[i],viewCount[i],time[i])
            videoListArrayList.add(youtubeData)

        }
        binding.verticalView.adapter = MyAdapter(videoListArrayList)
    }
    private fun getUserData() {
        for (i in subscriptionImageId.indices) {
            val showDot = i % 2 == 0
            val channelData = SubscriptionData(subscriptionImageId[i], heading[i],showDot)
            newArrayList.add(channelData)
        }
        newArrayList.add(SubscriptionData(0, "All",false))
        binding.subscriptionHorizontal.adapter = SubscriptionAdapter(newArrayList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}