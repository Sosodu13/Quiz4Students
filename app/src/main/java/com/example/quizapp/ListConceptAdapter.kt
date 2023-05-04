package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.model.ConceptDAO
import com.example.quizapp.model.QuestionDAO
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.ConceptChecked

class ListConceptAdapter (private val context : Context,
                          val result : List<ConceptChecked>) : RecyclerView.Adapter<ListConceptViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListConceptViewHolder {
        return ListConceptViewHolder(LayoutInflater.from(context).inflate(R.layout.concept_cell, parent, false))
    }

    override fun onBindViewHolder(holder: ListConceptViewHolder, position: Int) {
        val item = result[position] ?: return
        holder.tvLibel.text = item.concept.libel
        holder.tvTag.text = item.concept.tag

        holder.tvCheckBox.setOnCheckedChangeListener { buttonView, isChecked -> item.checked = isChecked }
    }

    override fun getItemCount(): Int {
        return result.count()
    }
}