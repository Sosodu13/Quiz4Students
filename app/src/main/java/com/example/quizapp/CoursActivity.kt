package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.model.ConceptDAO
import com.example.quizapp.model.CoursDAO
import com.example.quizapp.model.QuestionDAO
import com.example.quizapp.model.QuizDatabase
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.ConceptChecked
import com.example.quizapp.model.data.Cours
import kotlinx.android.synthetic.main.activity_concept.*
import kotlinx.android.synthetic.main.activity_cours.*
import kotlinx.android.synthetic.main.activity_main.*

class CoursActivity : AppCompatActivity() {

    inner class QueryCoursTask (
        private val context: Context,
        private val coursDao: CoursDAO,
        private val questionDao: QuestionDAO,
        private val listRechercheCours: RecyclerView
    ): AsyncTask<String, Void, List<Cours>>() {

        override fun onPreExecute() {
            listRechercheCours.visibility = View.INVISIBLE

        }
        override fun doInBackground(vararg params: String?): List<Cours> {

            val input = params[0] ?: return emptyList()

            return coursDao.getCoursByRecherche(input)

        }

        override fun onPostExecute(result: List<Cours>?) {
            listRechercheCours.layoutManager = LinearLayoutManager(context)
            listRechercheCours.adapter =
                ListCoursAdapter(context, result!!, coursDao, questionDao)
            listRechercheCours.visibility = View.VISIBLE

            val count = listRechercheCours.adapter!!.itemCount

            if (count == 0) {
                listRechercheCours.visibility = View.INVISIBLE
            }

        }

    }


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
        tv_total_cours_oublie.text = coursDao.getSumByTag("Oublié").toString()

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

        val questionList = questionDao.getWithoutFilter()

        findViewById<Button>(R.id.btn_start_from_cours).setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra("Questions", questionList.toTypedArray())
            startActivity(intent)
            finish()
        }

        inputCoursLibel.addTextChangedListener(object : TextWatcher {
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
                    var value = inputCoursLibel.text.toString()
                    value = "%$value%"

                    QueryCoursTask(applicationContext, coursDao, questionDao, lv_cours).execute(value)
                }else{
                    val adapter = ListCoursAdapter(applicationContext,coursList!!,coursDao, questionDao)
                    if(coursList.count() > 0){
                        val recyclerView = findViewById<RecyclerView>(R.id.lv_cours)
                        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                        recyclerView.adapter = adapter
                    }
                }
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cours)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}