package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.Cours

class CoursActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()

        // val db = EnterpriseDatabase.getDatabase(this)
        // val etablissementDao = db.etablissementDao()

        val coursList = ArrayList<Cours>()

        val cours1 = Cours(
            1,
            "Programmation",
            "Initiation"
        )
        coursList.add(cours1)

        val cours2 = Cours(
            2,
            "Communication",
            "Compréhension"
        )
        coursList.add(cours2)

        val cours3 = Cours(
            3,
            "Entreprise X.0",
            "Maîtrise"
        )
        coursList.add(cours3)

        if(coursList.count() > 0){
            val recyclerView = findViewById<RecyclerView>(R.id.lv_cours)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ListCoursAdapter(this,coursList!!/*,conceptDao*/)
        }

        findViewById<Button>(R.id.btn_cours_to_accueil).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_cours_to_concept).setOnClickListener {
            val intent = Intent(this, ConceptActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cours)
    }
}