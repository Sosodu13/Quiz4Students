package com.example.quizapp

import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListCoursViewHolder(row: View): RecyclerView.ViewHolder(row) {
    val tvLibel = row.findViewById<TextView>(R.id.item_libel)
    val tvTag = row.findViewById<TextView>(R.id.item_tag)
    val btnStartCours = row.findViewById<Button>(R.id.btn_start_cours)
}