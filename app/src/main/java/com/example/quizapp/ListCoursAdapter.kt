package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.model.CoursDAO
import com.example.quizapp.model.QuestionDAO
import com.example.quizapp.model.data.Cours
import com.example.quizapp.model.data.Question

class ListCoursAdapter (private val context : Context,
                        private val result : List<Cours>,
                        private val coursDao: CoursDAO,
                        private val questionDao: QuestionDAO) : RecyclerView.Adapter<ListCoursViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCoursViewHolder {
        return ListCoursViewHolder(LayoutInflater.from(context).inflate(R.layout.cours_cell, parent, false))
    }

    override fun onBindViewHolder(holder: ListCoursViewHolder, position: Int) {
        val cours = coursDao.getByPosition(position) ?: return

        val item = result[position] ?: return
        holder.tvLibel.text = item.libel
        holder.tvTag.text = item.tag

        val listQuestions = questionDao.getQuestionsByCoursId(cours.id)

        holder.btnStartCours.setOnClickListener {
            //Start activity quizz from cours
            val intent = Intent(context, QuizQuestionsActivity::class.java)
            intent.putExtra("Questions", listQuestions.toTypedArray())
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return result.count()
    }
}