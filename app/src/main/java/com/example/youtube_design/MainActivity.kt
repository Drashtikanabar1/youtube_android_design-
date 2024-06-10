package com.example.youtube_design


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.example.youtube_design.databinding.ActivityNavigationViewBinding
import com.example.youtube_design.ui.profile.ProfileFragment


class MainActivity : AppCompatActivity() {

    private var showSplashScreen = true
    private lateinit var binding: ActivityNavigationViewBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {

  installSplashScreen().setKeepOnScreenCondition {
            showSplashScreen
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showSplashScreen = false

        binding = ActivityNavigationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
            binding.customToolbar.profile.setOnClickListener {
            openProfileActivity()
        }


        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment_activity_home
        ) as NavHostFragment

        navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.mobile_navigation)
        binding.bottomNavigationView.setupWithNavController(navController)
        navController.graph = navGraph
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_Explore,
                R.id.navigation_library,
                R.id.navigation_subscription
            )
        )

//        setupActionBarWithNavController(navController, appBarConfiguration)

        setCurrentDestinationListener()


    }


    private fun setCurrentDestinationListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_home,
                R.id.navigation_Explore,
                R.id.navigation_library,
                R.id.navigation_subscription-> {
                    binding.bottomNavigationView.isVisible =true
                    binding.customToolbar.customToolbar.isVisible =true
                    binding.customNavFavouritesFab.isVisible =true
                }

                else -> {
                    binding.bottomNavigationView.isVisible = false
                    binding.customToolbar.customToolbar.isVisible =false
                    binding.customNavFavouritesFab.isVisible =false
                }
            }
        }
    }
    private fun openProfileActivity() {
        setCurrentDestinationListener()
        navController.navigate(R.id.profileFragment)
    }

   override fun onSupportNavigateUp(): Boolean {
    return navController.navigateUp(appBarConfiguration)
   }

}