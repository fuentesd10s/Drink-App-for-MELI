package com.fuentescreations.drinkappformeli.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.fuentescreations.drinkappformeli.R
import com.fuentescreations.drinkappformeli.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var b : ActivityMainBinding
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        navController = (supportFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment).navController
    }
}