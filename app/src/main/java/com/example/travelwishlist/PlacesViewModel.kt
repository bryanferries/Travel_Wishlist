package com.example.travelwishlist

import androidx.lifecycle.ViewModel

class PlacesViewModel: ViewModel() {

    private val placeNames = mutableListOf<String>("Auckland", "Patagonia")

    fun getPlaces(): List<String>  {
        return  placeNames       //smart cast
    }

    fun addNewPlace(place: String, position: Int? = null): Int {
        //return location in the list that the new item was added

//        for (placeName in placeNames) {
//            if (placeName.uppercase() == place.uppercase()) {
//                return -1     // -1 for none
//            }
//        }

        // all function returns true if all of the thigns in a list meet a condition
        // any function returns true if any of the things in a list meet a condition
        if (placeNames.any { placeName -> placeName.uppercase() == place.uppercase() }) {
            return -1
        }

        return if (position == null) {
            placeNames.add(place)
            placeNames.lastIndex
        } else {
            placeNames.add(position, place)             //adds at the end
            placeNames.lastIndex

        }
    }
}