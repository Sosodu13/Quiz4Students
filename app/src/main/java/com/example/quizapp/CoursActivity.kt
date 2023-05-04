package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.model.QuizDatabase
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.Cours
import kotlinx.android.synthetic.main.activity_concept.*
import kotlinx.android.synthetic.main.activity_cours.*
import kotlinx.android.synthetic.main.activity_main.*

class CoursActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()

        val db = QuizDatabase.getDatabase(this)
        val coursDao = db.coursdao()
        val questionDao = db.questiondao()

        val coursList = coursDao.getAll()

        //Mise à jour de la progression
        tv_total_cours_non_commence.text = coursDao.getSumByTag("Non commencé").toString()
        tv_total_cours_initiation.text = coursDao.getSumByTag("Initiation").toString()
        tv_total_cours_comprehension.text = coursDao.getSumByTag("Compréhension").toString()
        tv_total_cours_maitrise.text = coursDao.getSumByTag("Maîtrise").toString()
        
        if(coursList.count() > 0){
            val recyclerView = findViewById<RecyclerView>(R.id.lv_cours)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ListCoursAdapter(this,coursList!!,coursDao, questionDao)
        }

        findViewById<Button>(R.id.btn_cours_to_accueil).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_cours_to_concept).setOnClickListener {
            val intent = Intent(this, ConceptActivity::class.java)
            startActivity(intent)
        }

        val questionList = questionDao.getWithoutFilterCours()

        findViewById<Button>(R.id.btn_start_from_cours).setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra("Questions", questionList.toTypedArray())
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cours)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}