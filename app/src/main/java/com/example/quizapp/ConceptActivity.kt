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
import com.example.quizapp.model.data.ConceptChecked
import com.example.quizapp.model.data.Cours
import kotlinx.android.synthetic.main.activity_concept.*

class ConceptActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()

        val db = QuizDatabase.getDatabase(this)
        val conceptDao = db.conceptdao()
        val questionDao = db.questiondao()

        val conceptList = conceptDao.getAll()

        //Mise à jour de la progression
        tv_total_concept_non_commence.text = conceptDao.getSumByTag("Non commencé").toString()
        tv_total_concept_initiation.text = conceptDao.getSumByTag("Initiation").toString()
        tv_total_concept_comprehension.text = conceptDao.getSumByTag("Compréhension").toString()
        tv_total_concept_maitrise.text = conceptDao.getSumByTag("Maîtrise").toString()


        val concecptCheckList = conceptList.map { concept -> ConceptChecked(concept, false) }

        val adapter = ListConceptAdapter(this,concecptCheckList!!/*,conceptDao*/)
        if(conceptList.count() > 0){
            val recyclerView = findViewById<RecyclerView>(R.id.lv_concept)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = adapter
        }

        findViewById<Button>(R.id.btn_concept_to_accueil).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_concept_to_cours).setOnClickListener {
            val intent = Intent(this, CoursActivity::class.java)
            startActivity(intent)
        }


        findViewById<Button>(R.id.btn_start_from_concept).setOnClickListener {
            // lancement de reviser le meme filtre partout
            var questionList = questionDao.getWithoutFilter()
            val conceptList = concecptCheckList.filter { it.checked }.map { it.concept }

            if(conceptList.size != 0){
                var stringIdConcept = ""
                var arrayId = ArrayList<Long?>();
                var cpt = 0
                conceptList.forEach {
                    cpt ++
                    stringIdConcept += it.id
                    arrayId.add(it.id)
                    if(cpt != conceptList.size) {
                        stringIdConcept += ", "
                    }
                }
                questionList = questionDao.getQuestionsByConceptIdArray(arrayId.toTypedArray())
            }

            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra("Questions", questionList.toTypedArray())
            startActivity(intent)
            finish()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concept)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}