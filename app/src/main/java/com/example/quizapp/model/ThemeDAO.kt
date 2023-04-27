package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Query
import com.example.quizapp.model.data.Theme

@Dao
interface ThemeDAO {
    @Query("SELECT * FROM theme")
    fun getAll() : List<Theme>
}