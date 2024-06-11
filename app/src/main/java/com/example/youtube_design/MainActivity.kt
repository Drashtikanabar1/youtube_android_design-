package com.example.youtube_design


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.example.youtube_design.databinding.ActivityNavigationViewBinding


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
                R.id.navigation_home  ->{
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_home).setIcon(
                        R.drawable.home_selected_icon)
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_Explore).setIcon(R.drawable.explore_icon)
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_library).setIcon(R.drawable.library_icon)
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_subscription).setIcon(R.drawable.subscription_icon)
                    binding.bottomNavigationView.isVisible =true
                    binding.customToolbar.customToolbar.isVisible =true
                    binding.customNavFavouritesFab.isVisible =true

                }
                R.id.navigation_Explore -> {
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_home).setIcon(
                        R.drawable.home_icon)
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_Explore).setIcon(R.drawable.explore_selected_icon)
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_library).setIcon(R.drawable.library_icon)
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_subscription).setIcon(R.drawable.subscription_icon)
                    binding.bottomNavigationView.isVisible =true
                    binding.customToolbar.customToolbar.isVisible =true
                    binding.customNavFavouritesFab.isVisible =true
                                           }
                R.id.navigation_library-> {
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_home).setIcon(
                        R.drawable.home_icon)
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_Explore).setIcon(R.drawable.explore_icon)
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_library).setIcon(R.drawable.library_selected_icon)
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_subscription).setIcon(R.drawable.subscription_icon)
                    binding.bottomNavigationView.isVisible =true
                    binding.customToolbar.customToolbar.isVisible =true
                    binding.customNavFavouritesFab.isVisible =true
                }
                R.id.navigation_subscription-> {
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_home).setIcon(
                        R.drawable.home_icon)
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_Explore).setIcon(R.drawable.explore_icon)
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_library).setIcon(R.drawable.library_icon)
                    binding.bottomNavigationView.menu.findItem(R.id.navigation_subscription).setIcon(R.drawable.subscription_selected_icon)
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