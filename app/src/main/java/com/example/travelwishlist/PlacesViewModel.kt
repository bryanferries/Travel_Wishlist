package com.example.travelwishlist

import androidx.lifecycle.ViewModel

class PlacesViewModel: ViewModel() {

    private val placeNames = mutableListOf<String>("Auckland", "Patagonia")

    fun getPlaces(): List<String>  {
        return  placeNames       //smart cast
    }

    fun addNewPlace(place: String, position: Int? = null): Int {
        //return location in the list that the new item was added
        placeNames.add(place)             //adds at the end
        return placeNames.lastIndex

    }
}