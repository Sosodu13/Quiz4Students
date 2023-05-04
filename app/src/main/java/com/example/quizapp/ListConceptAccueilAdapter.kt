package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.model.ConceptDAO
import com.example.quizapp.model.QuestionDAO
import com.example.quizapp.model.data.Concept

class ListConceptAccueilAdapter (private val context : Context,
                                 private val result : List<Concept>,
                                 private val questionDao: QuestionDAO,
                                 private val conceptDao: ConceptDAO) : RecyclerView.Adapter<ListConceptAccueilViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListConceptAccueilViewHolder {
        return ListConceptAccueilViewHolder(LayoutInflater.from(context).inflate(R.layout.list_accueil_cell, parent, false))
    }

    override fun onBindViewHolder(holder: ListConceptAccueilViewHolder, position: Int) {
        val concept = conceptDao.getByPosition(position) ?: return

        val item = result[position] ?: return
        holder.tvLibel.text = item.libel
        holder.tvTag.text = item.tag

        val listQuestions = questionDao.getQuestionsByConceptId(concept.id.toString())

        holder.itemView.setOnClickListener {
            //Start activity quizz from cours
            val intent = Intent(context, QuizQuestionsActivity::class.java)
            intent.putExtra("Questions", listQuestions.toTypedArray())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return result.count()
    }
}