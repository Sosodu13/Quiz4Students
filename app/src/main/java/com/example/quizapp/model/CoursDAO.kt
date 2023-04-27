package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Query
import com.example.quizapp.model.data.Cours

@Dao
interface CoursDAO {
    @Query("SELECT * FROM cours")
    fun getAll() : List<Cours>
}