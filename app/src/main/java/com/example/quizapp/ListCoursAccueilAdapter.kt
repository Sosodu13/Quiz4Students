package com.example.quizapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.Cours

class ListCoursAccueilAdapter (private val context : Context,
                                private val result : List<Cours>/*,
                                 private val conceptDAO: ConceptDAO*/) : RecyclerView.Adapter<ListCoursAccueilViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCoursAccueilViewHolder {
        return ListCoursAccueilViewHolder(LayoutInflater.from(context).inflate(R.layout.list_accueil_cell, parent, false))
    }

    override fun onBindViewHolder(holder: ListCoursAccueilViewHolder, position: Int) {val item = result[position] ?: return
        holder.tvLibel.text = item.libel
        holder.tvTag.text = item.tag
    }

    override fun getItemCount(): Int {
        return result.count()
    }
}