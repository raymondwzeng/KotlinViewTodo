package com.example.kotlinviewtodo.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinviewtodo.R

/*
    ListAdapter.kt

    The actual adapter to bind the data and views together.
    This code was lifted mainly from the Android Developer wiki on RecyclerViews as part of an effort to learn more.
 */

class ListAdapter(private val dataSet: List<String>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    //Actually grabs the reference to the text view within the list_element layout.
    //The ONLY instance of fVBI in this code.
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val textView : TextView = view.findViewById(R.id.text_view)
    }

    //Grabs the view holder, grabs the item, and INFLATE!
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_element, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("At position $position")
        holder.textView.text = dataSet[position]
    }

    override fun getItemCount(): Int = dataSet.size
}