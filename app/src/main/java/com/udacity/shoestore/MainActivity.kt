package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var  navController : NavController
    private lateinit var  appBarConfiguration  : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)


        Timber.plant(Timber.DebugTree())

        setSupportActionBar(binding.toolbar)
    }

    override fun onStart() {
        super.onStart()
        setUpNavigatio()
    }

    private fun setUpNavigatio() {
        navController =findNavController(R.id.myNavHost)
       val appBarConfiguration  = AppBarConfiguration(getSetOfHomeDestinatons())
        setupActionBarWithNavController(navController,appBarConfiguration)
    }

    private fun getSetOfHomeDestinatons() = setOf(R.id.Login_Screen,R.id.welcomeScreen,R.id.instructionsScreen,R.id.shoeList)

    override fun onSupportNavigateUp() = navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()


    }
