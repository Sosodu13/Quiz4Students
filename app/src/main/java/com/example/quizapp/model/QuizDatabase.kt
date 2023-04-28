package com.example.quizapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quizapp.model.data.*

@Database(entities = [Concept::class, ConceptTheme::class, Cours::class, Question::class, Response::class, Theme::class, ThemeCours::class], version = 1)
abstract class QuizDatabase: RoomDatabase() {

    abstract fun questiondao():QuestionDAO
    abstract fun conceptdao():ConceptDAO
    abstract fun coursdao():CoursDAO
    abstract fun responsedao():ResponseDAO
    abstract fun theme_coursdao():ThemeCoursDAO
    abstract fun concept_themedao():ConceptThemeDAO
    abstract fun themedao():ThemeDAO

    companion object {
        private var INSTANCE: QuizDatabase? = null
        @JvmStatic fun getDatabase(context: Context): QuizDatabase {
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