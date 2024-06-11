package com.example.youtube_design.ui.Explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube_design.R

import com.example.youtube_design.databinding.FragmentExploreBinding
import com.example.youtube_design.ui.home.MyAdapter
import com.example.youtube_design.ui.home.YoutubeClass

class DashboardFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<YoutubeClass>
    private lateinit var horizontalRecyclerView: RecyclerView
    private lateinit var exploreList: ArrayList<ExploreClass>
    lateinit var imageId :Array<Int>
    lateinit var backgroundImage :Array<Int>
    lateinit var iconImage :Array<Int>

    lateinit var filterNames: Array<String>
    lateinit var heading :Array<String>
    lateinit var subHeading :Array<String>
    lateinit var viewCount :Array<String>
    lateinit var time :Array<String>
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val root: View = binding.root
//
//        val buttonTitles = listOf("Trending", "Music", "Gaming")
//        val buttonBackgrounds = listOf(R.drawable.background_trending, R.drawable.background_music, R.drawable.background_gaming)

        return root
    }
    private fun getFilterData() {
        for (i in filterNames.indices) {
            val filterData = ExploreClass(backgroundImage[i],iconImage[i],filterNames[i])
            exploreList.add(filterData)
        }
        horizontalRecyclerView.adapter = ExploreAdapter(exploreList)
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

        iconImage = arrayOf(
         R.drawable.trending,
            R.drawable.music_icon,
            R.drawable.gaming_icon,
            R.drawable.news_icon,
            R.drawable.local_movies_icon,
            R.drawable.clothes_hanger_icon,
            R.drawable.learning_icon,
            R.drawable.live_icon,
            R.drawable.sport_icon,
        )

        backgroundImage = arrayOf(
            R.drawable.tranding,
            R.drawable.music,
            R.drawable.gaming,
            R.drawable.news,
            R.drawable.films,
            R.drawable.fashion_beauty,
            R.drawable.learning,
            R.drawable.live,
            R.drawable.sport
        )

        filterNames = arrayOf(
            "Trending",
            "Music",
            "Gaming",
            "News",
            "Films",
            "Fashion & beauty",
            "Learning",
            "Live",
            "Sport"
        )
        newRecyclerView = view.findViewById(R.id.imageCardView)
        newRecyclerView.layoutManager = LinearLayoutManager(context)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<YoutubeClass>()
        getUserData()


        horizontalRecyclerView = view.findViewById(R.id.gridRecycleView)
        horizontalRecyclerView.layoutManager = GridLayoutManager(context,2)
        horizontalRecyclerView.setHasFixedSize(true)
        exploreList = arrayListOf()
        getFilterData()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}