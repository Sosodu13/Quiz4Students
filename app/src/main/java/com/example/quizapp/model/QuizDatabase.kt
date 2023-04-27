package com.example.quizapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quizapp.Question

@Database(entities = [Question::class], version = 1)
abstract class QuizDatabase: RoomDatabase() {

//    abstract fun Questiondao():QuestionDao

    companion object {
        private var INSTANCE: QuizDatabase? = null
        fun getDatabase(context: Context): QuizDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context, QuizDatabase::class.java, "entrperise.db")
                    .addCallback(DatabaseSeeder(context))
                    .allowMainThreadQueries()
                    .build()
            }

            return INSTANCE!!
        }
    }

}