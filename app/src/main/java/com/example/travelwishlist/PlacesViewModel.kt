package com.example.travelwishlist

import android.util.Log
import androidx.lifecycle.ViewModel

import java.util.*

const val TAG = "PLACES_VIEW_MODEL"
class PlacesViewModel: ViewModel() {

    private val places = mutableListOf<Place>(Place("Auckland, NZ", "Lord of the Rings Set"),
        Place("Patagonia", "Clothing Brand"))

    fun getPlaces(): List<Place>  {
        return places       //smart cast
    }

    fun addNewPlace(place: Place, position: Int? = null): Int {
        //return location in the list that the new item was added

//        for (placeName in placeNames) {
//            if (placeName.name.uppercase() == place..name.uppercase()) {
//                return -1     // -1 for none
//            }
//        }

        // all function returns true if all of the thigns in a list meet a condition
        // any function returns true if any of the things in a list meet a condition
        if (places.any { placeName -> placeName.name.uppercase() == place.name.uppercase() }) {
            return -1
        }

        return if (position == null) {
            places.add(place)
            places.lastIndex
        } else {
            places.add(position, place)             //adds at the end
            places.lastIndex

        }
    }

    fun movePlace(from: Int, to: Int) {
        val place = places.removeAt(from)
        places.add(to, place)
        Log.d(TAG, places.toString())
    }
    fun deletePlace(position: Int): Place {       // remove ? if needed
        return places.removeAt(position)
    }
}