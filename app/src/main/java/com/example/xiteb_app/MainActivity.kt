package com.example.xiteb_app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var planetAdapter: PlanetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchPlanets()
    }

    private fun fetchPlanets() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.instance.getPlanets()
                withContext(Dispatchers.Main) {
                    val planets = response.results
                    planetAdapter = PlanetAdapter(planets) { planet ->
                        val intent = Intent(this@MainActivity, PlanetDetailActivity::class.java).apply {
                            putExtra("name", planet.name)
                            putExtra("orbital_period", planet.orbital_period)
                            putExtra("gravity", planet.gravity)
                            putExtra("climate", planet.climate)
                        }
                        startActivity(intent)
                    }
                    recyclerView.adapter = planetAdapter
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Error fetching planets: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
