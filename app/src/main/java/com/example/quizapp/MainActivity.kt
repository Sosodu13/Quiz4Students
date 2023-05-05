package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.model.QuizDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz_questions.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()

        val db = QuizDatabase.getDatabase(this)
        db.seed()

        val questionDao = db.questiondao()
        val conceptDao = db.conceptdao()
        val coursDao = db.coursdao()

        val questionsList = questionDao.getAll()

        var dt_oublie = Date()
        val c = Calendar.getInstance()
        c.time = dt_oublie
        c.add(Calendar.DATE, -30)
        dt_oublie = c.time
        System.out.println(dt_oublie.time)
        System.out.println(dt_oublie)

        questionsList.forEach{

            if(it.date_response != null) {
                if(it.date_response!! < dt_oublie.time){
                    it.validated = false
                    db.questiondao().update(it)
                }
            }
        }

        val conceptList = conceptDao.getAllHome()

        conceptList.forEach {
            val total_question_oublie = conceptDao.getCountQuestionOublie(it.id)
            val total_question = conceptDao.getCountQuestionByConceptd(it.id)
            val purcentage = (total_question_oublie * 100) / total_question
            System.out.println(total_question_oublie)
            System.out.println(total_question)
            System.out.println(purcentage)

            if(purcentage >= 50){
                it.tag = "Oublié"
                conceptDao.update(it)
            }
        }

        val coursList = coursDao.getAllHome()

        coursList.forEach {
            val total_concept_oublie = coursDao.getCountConceptOublie(it.id)
            val total_concept = coursDao.getCountConcept(it.id)

            if((total_concept_oublie * 100) / total_concept >= 50){
                it.tag = "Oublié"
                coursDao.update(it)
            }
        }

        val conceptListUpdate = conceptDao.getAll()
        val coursListUpdate = coursDao.getAll()

        //Mise à jour de la progression
        tv_total_concept_accueil_non_commence.text = db.conceptdao().getSumByTag("Non commencé").toString()
        tv_total_concept_accueil_initiation.text = db.conceptdao().getSumByTag("Initiation").toString()
        tv_total_concept_accueil_comprehension.text = db.conceptdao().getSumByTag("Compréhension").toString()
        tv_total_concept_accueil_maitrise.text = db.conceptdao().getSumByTag("Maîtrise").toString()
        tv_total_concept_accueil_oublie.text = db.conceptdao().getSumByTag("Oublié").toString()


        tv_total_cours_accueil_non_commence.text = db.coursdao().getSumByTag("Non commencé").toString()
        tv_total_cours_accueil_initiation.text = db.coursdao().getSumByTag("Initiation").toString()
        tv_total_cours_accueil_comprehension.text = db.coursdao().getSumByTag("Compréhension").toString()
        tv_total_cours_accueil_maitrise.text = db.coursdao().getSumByTag("Maîtrise").toString()
        tv_total_cours_accueil_oublie.text = db.coursdao().getSumByTag("Oublié").toString()

        if(conceptListUpdate.count() > 0){
            val recyclerView = findViewById<RecyclerView>(R.id.lv_concept)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ListConceptAccueilAdapter(this,conceptListUpdate!!, questionDao, conceptDao)
        }

        if(coursListUpdate.count() > 0){
            val recyclerView = findViewById<RecyclerView>(R.id.lv_cours)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ListCoursAccueilAdapter(this,coursListUpdate!!,questionDao, coursDao)
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