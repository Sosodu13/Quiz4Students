package com.example.quizapp.model

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.quizapp.Question

class DatabaseSeeder(private val context: Context) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        // Ajouter des données à la base de données ici
        val questionDao = QuizDatabase.getDatabase(context).questionDao()
        val user1 = Question(1, "John Doe", "30","30","30","30",1 )
        val user2 = Question(2, "Jane Smith", "25","30","30","30",1)
        questionDao.insertAll(user1, user2)
    }
}
