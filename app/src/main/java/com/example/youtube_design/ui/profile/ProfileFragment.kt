package com.example.youtube_design.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube_design.R
import com.example.youtube_design.databinding.FragmentHomeBinding
import com.example.youtube_design.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }
    private var _binding: FragmentProfileBinding? = null
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<ProfileClass>
     lateinit var imageId :Array<Int>
    lateinit var heading :Array<String>

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.backButton.setOnClickListener {

            parentFragmentManager.popBackStack()
        }
        // getting the employeelist
        imageId  = arrayOf(
            R.drawable.person_icon,
            R.drawable.youtube_studio_icon,
            R.drawable.bar_chart_icon,
            R.drawable.play_button_svg,
            R.drawable.attach_money_icon,
            R.drawable.video_library,
            R.drawable.incognito_icon,
            R.drawable.verified_user_icon,
            R.drawable.settings_icon,
            R.drawable.help_outline_icon
        )

        heading = arrayOf(
            "Your Channel",
            "YouTube Studio",
            "Time watched",
            "Get YouTube Premium",
            "Purchases and memberships",
            "Switch account",
            "Turn on Incognito",
            "Your data in YouTube",
            "Settings",
            "Help and feedback"
        )

        newRecyclerView = view.findViewById(R.id.imageCardView)
        newRecyclerView.layoutManager = LinearLayoutManager(context)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<ProfileClass>()
        getUserData()
    }

    private fun getUserData(){

        for(i in imageId.indices){
            val profileData = ProfileClass(imageId[i],heading[i],)
            newArrayList.add(profileData)

        }
        newRecyclerView.adapter = ProfileAdapter(newArrayList)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}