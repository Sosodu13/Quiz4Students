package com.example.quizapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListConceptAccueilViewHolder(row: View): RecyclerView.ViewHolder(row) {
    val tvLibel = row.findViewById<TextView>(R.id.item_libel)
    val tvTag = row.findViewById<TextView>(R.id.item_tag)
}
