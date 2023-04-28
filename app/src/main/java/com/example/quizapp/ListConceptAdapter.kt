package com.example.quizapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.model.data.Concept

class ListConceptAdapter (private val context : Context,
                          private val result : List<Concept>/*,
                                 private val conceptDAO: ConceptDAO*/) : RecyclerView.Adapter<ListConceptViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListConceptViewHolder {
        return ListConceptViewHolder(LayoutInflater.from(context).inflate(R.layout.concept_cell, parent, false))
    }

    override fun onBindViewHolder(holder: ListConceptViewHolder, position: Int) {val item = result[position] ?: return
        holder.tvLibel.text = item.libel
        holder.tvTag.text = item.tag
    }

    override fun getItemCount(): Int {
        return result.count()
    }
}