package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quizapp.model.data.Response
import com.example.quizapp.model.data.ThemeCours

@Dao
interface ThemeCoursDAO {
    @Query("SELECT * FROM themecours")
    fun getAll() : List<ThemeCours>

    @Insert
    fun insertAll(vararg theme_cours: ThemeCours)

}