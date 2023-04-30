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

class ConceptActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()

        val db = QuizDatabase.getDatabase(this)
        val conceptDao = db.conceptdao()

        val conceptList = conceptDao.getAll()

        if(conceptList.count() > 0){
            val recyclerView = findViewById<RecyclerView>(R.id.lv_concept)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ListConceptAdapter(this,conceptList!!/*,conceptDao*/)
        }

        findViewById<Button>(R.id.btn_concept_to_accueil).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_concept_to_cours).setOnClickListener {
            val intent = Intent(this, CoursActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concept)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}