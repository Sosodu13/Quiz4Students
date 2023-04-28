package com.example.quizapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.model.data.Cours

class ListCoursAdapter (private val context : Context,
                        private val result : List<Cours>/*,
                                 private val conceptDAO: ConceptDAO*/) : RecyclerView.Adapter<ListCoursViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCoursViewHolder {
        return ListCoursViewHolder(LayoutInflater.from(context).inflate(R.layout.cours_cell, parent, false))
    }

    override fun onBindViewHolder(holder: ListCoursViewHolder, position: Int) {
        val item = result[position] ?: return
        holder.tvLibel.text = item.libel
        holder.tvTag.text = item.tag
    }

    override fun getItemCount(): Int {
        return result.count()
    }
}