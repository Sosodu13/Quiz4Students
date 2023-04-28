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
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.Cours
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()

        // val db = EnterpriseDatabase.getDatabase(this)
        // val etablissementDao = db.etablissementDao()

        val conceptList = ArrayList<Concept>()

        val question1 = Concept(
            1,
            "Programmation",
            "Initiation"
        )
        conceptList.add(question1)
        val question2 = Concept(
            2,
            "Communication",
            "Compréhension"
        )
        conceptList.add(question2)
        val question3 = Concept(
            3,
            "Entreprise X.0",
            "Maîtrise"
        )
        conceptList.add(question3)

        if(conceptList.count() > 0){
            val recyclerView = findViewById<RecyclerView>(R.id.lv_concept)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ListConceptAccueilAdapter(this,conceptList!!/*,conceptDao*/)
        }


        val coursList = ArrayList<Cours>()

        val cours1 = Cours(
            1,
            "Créer son site web",
            "Initiation"
        )
        coursList.add(cours1)
        val cours2 = Cours(
            2,
            "Communication digitale",
            "Compréhension"
        )
        coursList.add(cours2)

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