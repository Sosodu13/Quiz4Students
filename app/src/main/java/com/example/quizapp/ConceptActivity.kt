package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.model.ConceptDAO
import com.example.quizapp.model.QuizDatabase
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.ConceptChecked
import kotlinx.android.synthetic.main.activity_concept.*


class ConceptActivity : AppCompatActivity() {

    inner class QueryConceptTask (
        private val context: Context,
        private val conceptDAO: ConceptDAO,
        private val listRechercheConcept: RecyclerView
    ): AsyncTask<String,Void, List<ConceptChecked>>(){

        override fun onPreExecute() {
            listRechercheConcept.visibility = View.INVISIBLE
        }

        override fun doInBackground(vararg params: String?): List<ConceptChecked> {

            val input = params[0] ?: return emptyList()

            val conceptList =  conceptDAO.getConceptsByRecherche(input)

            val concecptCheckList = conceptList.map { concept -> ConceptChecked(concept, false) }

            return concecptCheckList

        }

        override fun onPostExecute(result: List<ConceptChecked>?) {
            listRechercheConcept.layoutManager = LinearLayoutManager(context)
            listRechercheConcept.adapter = ListConceptAdapter(context, result!!)
            listRechercheConcept.visibility = View.VISIBLE

            val count = listRechercheConcept.adapter!!.itemCount

            if(count == 0)
            {
                listRechercheConcept.visibility = View.INVISIBLE
            }

        }

    }

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
        tv_total_concept_oublie.text = conceptDao.getSumByTag("Oublié").toString()


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


        val db = QuizDatabase.getDatabase(this)
        val conceptDao = db.conceptdao()

        val conceptList = conceptDao.getAll()

        inputConceptLibel.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (s.length != 0) {
                    var value = inputConceptLibel.text.toString()
                    value = "%$value%"

                    QueryConceptTask(applicationContext, conceptDao, lv_concept).execute(value)
                }else{
                    val concecptCheckList = conceptList.map { concept -> ConceptChecked(concept, false) }

                    val adapter = ListConceptAdapter(applicationContext,concecptCheckList!!)
                    if(conceptList.count() > 0){
                        val recyclerView = findViewById<RecyclerView>(R.id.lv_concept)
                        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                        recyclerView.adapter = adapter
                    }
                }
            }
        })


    }
}