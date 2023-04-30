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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()

        // val db = EnterpriseDatabase.getDatabase(this)
        // val etablissementDao = db.etablissementDao()

        val db = QuizDatabase.getDatabase(this)
        db.seed()

        val conceptDao = db.conceptdao()

        val conceptList = conceptDao.getAll()

        if(conceptList.count() > 0){
            val recyclerView = findViewById<RecyclerView>(R.id.lv_concept)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ListConceptAccueilAdapter(this,conceptList!!/*,conceptDao*/)
        }

        val coursDao = db.coursdao()

        val coursList = coursDao.getAll()

        if(coursList.count() > 0){
            val recyclerView = findViewById<RecyclerView>(R.id.lv_cours)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ListCoursAccueilAdapter(this,coursList!!/*,conceptDao*/)
        }

        findViewById<Button>(R.id.btn_accueil_to_concept).setOnClickListener {
            val intent = Intent(this, ConceptActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_accueil_to_cours).setOnClickListener {
            val intent = Intent(this, CoursActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btn_start.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}