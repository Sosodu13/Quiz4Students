package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quizapp.model.data.Response
import com.example.quizapp.model.data.Theme

@Dao
interface ThemeDAO {
    @Query("SELECT * FROM theme")
    fun getAll() : List<Theme>

    @Insert
    fun insertAll(vararg themes: Theme)
}