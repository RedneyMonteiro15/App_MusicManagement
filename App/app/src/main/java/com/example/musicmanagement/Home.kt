package com.example.musicmanagement

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.musicmanagement.databinding.ActivityHomeBinding
import com.google.android.material.navigation.NavigationView


class Home : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarHome.toolbar)

        drawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_home)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val addIcon: ImageView = findViewById(R.id.imageView5)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val textView: TextView = findViewById(R.id.textView5)
            when (destination.id) {
                R.id.nav_home -> {
                    textView.text = "Home"
                    addIcon.visibility = View.VISIBLE
                }
                R.id.nav_gallery -> {
                    textView.text = "Gallery"
                    addIcon.visibility = View.INVISIBLE
                }
                R.id.nav_slideshow -> {
                    textView.text = "Slideshow"
                    addIcon.visibility = View.INVISIBLE
                }
            }
        }

        val menuIcon: ImageView = findViewById(R.id.imageView4)
        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }
}
