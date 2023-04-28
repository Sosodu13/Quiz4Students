package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.Cours

class ConceptActivity : AppCompatActivity() {
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

        findViewById<Button>(R.id.btn_concept_to_accueil).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concept)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}