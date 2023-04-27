package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Query
import com.example.quizapp.model.data.Concept_Theme

@Dao
interface Concept_ThemeDAO {
    @Query("SELECT * FROM concept_theme")
    fun getAll() : List<Concept_Theme>
}