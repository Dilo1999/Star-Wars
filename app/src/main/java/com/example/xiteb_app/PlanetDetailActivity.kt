package com.example.xiteb_app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PlanetDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_detail)

        // Retrieve planet details from intent extras
        val name = intent.getStringExtra("name") ?: "Unknown"
        val orbitalPeriod = intent.getStringExtra("orbital_period") ?: "Unknown"
        val gravity = intent.getStringExtra("gravity") ?: "Unknown"
        val climate = intent.getStringExtra("climate") ?: "Unknown"

        // Get references to the TextViews in the layout
        val tvName: TextView? = findViewById(R.id.tvName)
        val tvOrbitalPeriod: TextView? = findViewById(R.id.tvOrbitalPeriod)
        val tvGravity: TextView? = findViewById(R.id.tvGravity)
        val tvClimate: TextView? = findViewById(R.id.tvClimate) // New climate TextView

        // Safely display the planet details in the respective TextViews
        tvName?.text = "Name: $name"
        tvOrbitalPeriod?.text = "Orbital Period: $orbitalPeriod"
        tvGravity?.text = "Gravity: $gravity"
        tvClimate?.text = "Climate: $climate" // Display climate
    }
}
