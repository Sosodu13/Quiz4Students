package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.model.CoursDAO
import com.example.quizapp.model.QuestionDAO
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.Cours

class ListCoursAccueilAdapter (private val context : Context,
                               private val result : List<Cours>,
                               private val questionDao: QuestionDAO,
                               private val coursDao: CoursDAO) : RecyclerView.Adapter<ListCoursAccueilViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCoursAccueilViewHolder {
        return ListCoursAccueilViewHolder(LayoutInflater.from(context).inflate(R.layout.list_accueil_cell, parent, false))
    }

    override fun onBindViewHolder(holder: ListCoursAccueilViewHolder, position: Int) {
        val cours = coursDao.getByPosition(position) ?: return

        val item = result[position] ?: return
        holder.tvLibel.text = item.libel
        holder.tvTag.text = item.tag

        val listQuestions = questionDao.getQuestionsByCoursId(cours.id)

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