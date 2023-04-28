package com.example.quizapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListConceptViewHolder(row: View): RecyclerView.ViewHolder(row) {
    val tvCheckBox = row.findViewById<TextView>(R.id.checkBoxConcept)
    val tvLibel = row.findViewById<TextView>(R.id.item_libel)
    val tvTag = row.findViewById<TextView>(R.id.item_tag)
}