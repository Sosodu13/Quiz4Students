package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.Cours

@Dao
interface CoursDAO {
    @Query("SELECT * FROM cours")
    fun getAll() : List<Cours>

    @Insert
    fun insertAll(vararg cours: Cours)

}