package com.example.xiteb_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PlanetAdapter(private val planets: List<Planet>, private val onItemClick: (Planet) -> Unit) :
    RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.planet_item, parent, false)
        return PlanetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val planet = planets[position]
        holder.bind(planet, onItemClick, position)
    }

    override fun getItemCount(): Int = planets.size

    class PlanetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val planetName: TextView = itemView.findViewById(R.id.tvPlanetName)
        private val climate: TextView = itemView.findViewById(R.id.tvClimate)
        private val planetImage: ImageView = itemView.findViewById(R.id.planetImage)

        fun bind(planet: Planet, onItemClick: (Planet) -> Unit, position: Int) {
            planetName.text = planet.name
            climate.text = itemView.context.getString(R.string.climate_label, planet.climate)

            // Load random planet image from picsum.photos
            Picasso.get().load("https://picsum.photos/200/200?random=$position").into(planetImage)

            itemView.setOnClickListener {
                onItemClick(planet)
            }
        }
    }
}
