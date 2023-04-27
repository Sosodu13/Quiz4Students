package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Query
import com.example.quizapp.model.data.Theme_Cours

@Dao
interface Theme_CoursDAO {
    @Query("SELECT * FROM theme_cours")
    fun getAll() : List<Theme_Cours>
}