package com.example.youtube_design.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube_design.FliterClass
import com.example.youtube_design.R
import com.example.youtube_design.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<YoutubeClass>
    private lateinit var horizontalRecyclerView: RecyclerView
    private lateinit var filterArrayList: ArrayList<FliterClass>
    lateinit var imageId :Array<Int>
    lateinit var filterNames: Array<String>
    lateinit var heading :Array<String>
    lateinit var subHeading :Array<String>
    lateinit var viewCount :Array<String>
    lateinit var time :Array<String>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root


    }
    private fun getFilterData() {
        for (i in filterNames.indices) {
            val filterData = FliterClass(filterNames[i])
            filterArrayList.add(filterData)
        }
        horizontalRecyclerView.adapter = FilterAdapter(filterArrayList)
    }

    private fun getUserData(){

        for(i in imageId.indices){

            val youtubeData = YoutubeClass(imageId[i],heading[i],subHeading[i],viewCount[i],time[i])
            newArrayList.add(youtubeData)

        }
        newRecyclerView.adapter = MyAdapter(newArrayList)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // getting the employeelist
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
        filterNames = arrayOf(
            "All",
            "UI Design",
            "UX Design",
            "Mixes",
            "Adobe XD",
        )
        newRecyclerView = view.findViewById(R.id.imageCardView)
        newRecyclerView.layoutManager = LinearLayoutManager(context)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<YoutubeClass>()
        getUserData()


        horizontalRecyclerView = view.findViewById(R.id.horizontalRecyclerView)
        horizontalRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        horizontalRecyclerView.setHasFixedSize(true)
        filterArrayList = arrayListOf()
        getFilterData()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

