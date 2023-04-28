package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quizapp.model.data.ConceptTheme
import com.example.quizapp.model.data.Question

@Dao
interface ConceptThemeDAO {
    @Query("SELECT * FROM concepttheme")
    fun getAll() : List<ConceptTheme>

    @Insert
    fun insertAll(vararg conceptsThemes: ConceptTheme)
}