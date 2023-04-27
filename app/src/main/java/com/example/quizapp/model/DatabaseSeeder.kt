package com.example.quizapp.model

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.quizapp.model.data.Question

class DatabaseSeeder(private val context: Context) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        // Ajouter des données à la base de données ici
        val questionDao = QuizDatabase.getDatabase(context).questiondao()
        val question1 = Question(1, "John Doe ?", "30",true, 1 )
        val question2 = Question(2, "Jane Smith ?", "25",false, 1)
        questionDao.insertAll(question1, question2)
    }
}
