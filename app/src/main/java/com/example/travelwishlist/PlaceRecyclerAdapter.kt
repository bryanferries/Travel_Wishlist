package com.example.travelwishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


interface OnListItemClickedListener {
    fun onListItemClicked(place: Place)
}

class PlaceRecyclerAdapter(private val places: List<Place>,
                            private val onListItemClickedListener: OnListItemClickedListener):
    RecyclerView.Adapter<PlaceRecyclerAdapter.ViewHolder>() {

    //manages on view - one list item - sets the actual datal in the view
        inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
            fun bind(place: Place) {
                val placeNameTextView: TextView = view.findViewById(R.id.place_name)
                placeNameTextView.text = place.name

                val dateCreatedOnTextView: TextView = view.findViewById(R.id.date_place_added)
                val createdOnText = view.context.getString(R.string.created_on, place.formattedDate())
                dateCreatedOnTextView.text = createdOnText

                val androidIcon: ImageView = view.findViewById(R.id.android_icon)
                androidIcon.setOnClickListener {
                //wHat now?
                onListItemClickedListener.onListItemClicked(place)
            }
            }
        }

    // create a ViewHolder for a specific position?  (combo view + data)

    // bind the view holder with data for a specific position


    //called by the recyclerview to crate as many viewholders that are needed to display the list on screen
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.place_list_item, parent, false)
    return ViewHolder(view)
    }

    // called by the recyler view to set
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = places[position]
        holder.bind(place)
    }


override fun getItemCount(): Int {
return places.size
    }
}