package com.example.travelwishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newPlaceEditText: EditText
    private lateinit var addNewPlaceButton: Button
    private lateinit var placeListRecyclerView: RecyclerView

    private lateinit var placesRecyclerAdapter: PlaceRecyclerAdapter

    private val placesViewModel: PlacesViewModel by lazy {
        ViewModelProvider(this).get(PlacesViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        placeListRecyclerView = findViewById(R.id.place_list)
        addNewPlaceButton = findViewById(R.id.add_new_place_button)
        newPlaceEditText = findViewById(R.id.new_place_name)

val places = placesViewModel.getPlaces()

        placesRecyclerAdapter = PlaceRecyclerAdapter(places)
        placeListRecyclerView.layoutManager = LinearLayoutManager(this)
        placeListRecyclerView.adapter = placesRecyclerAdapter

        addNewPlaceButton.setOnClickListener {
            addNewPlace()
        }
    }

    private fun addNewPlace() {
        val name = newPlaceEditText.text.toString().trim()
        if (name.isEmpty()) {
            Toast.makeText(this, "Enter a place name", Toast.LENGTH_LONG).show()
        } else {
            val positionAdded = placesViewModel.addNewPlace(name)
            placesRecyclerAdapter.notifyItemInserted(positionAdded)
        }
    }
}