package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.model.QuizDatabase
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.Cours
import kotlinx.android.synthetic.main.activity_concept.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()

        // val db = EnterpriseDatabase.getDatabase(this)
        // val etablissementDao = db.etablissementDao()

        val db = QuizDatabase.getDatabase(this)
        db.seed()


        //Mise à jour de la progression
        tv_total_concept_accueil_non_commence.text = db.conceptdao().getSumByTag("Non commencé").toString()
        tv_total_concept_accueil_initiation.text = db.conceptdao().getSumByTag("Initiation").toString()
        tv_total_concept_accueil_comprehension.text = db.conceptdao().getSumByTag("Compréhension").toString()
        tv_total_concept_accueil_maitrise.text = db.conceptdao().getSumByTag("Maîtrise").toString()


        tv_total_cours_accueil_non_commence.text = db.coursdao().getSumByTag("Non commencé").toString()
        tv_total_cours_accueil_initiation.text = db.coursdao().getSumByTag("Initiation").toString()
        tv_total_cours_accueil_comprehension.text = db.coursdao().getSumByTag("Compréhension").toString()
        tv_total_cours_accueil_maitrise.text = db.coursdao().getSumByTag("Maîtrise").toString()

        val questionDao = db.questiondao()
        val conceptDao = db.conceptdao()
        val coursDao = db.coursdao()

        val conceptList = conceptDao.getAllHome()
        if(conceptList.count() > 0){
            val recyclerView = findViewById<RecyclerView>(R.id.lv_concept)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ListConceptAccueilAdapter(this,conceptList!!, questionDao, conceptDao)
        }

        val coursList = coursDao.getAllHome()
        if(coursList.count() > 0){
            val recyclerView = findViewById<RecyclerView>(R.id.lv_cours)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ListCoursAccueilAdapter(this,coursList!!,questionDao, coursDao)
        }

        findViewById<Button>(R.id.btn_accueil_to_concept).setOnClickListener {
            val intent = Intent(this, ConceptActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_accueil_to_cours).setOnClickListener {
            val intent = Intent(this, CoursActivity::class.java)
            startActivity(intent)
        }

        val questionList = questionDao.getWithoutFilter()
        findViewById<Button>(R.id.btn_start_from_home).setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra("Questions", questionList.toTypedArray())
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

    }
}