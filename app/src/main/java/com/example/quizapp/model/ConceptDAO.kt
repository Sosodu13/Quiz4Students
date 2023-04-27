package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Query
import com.example.quizapp.model.data.Concept

@Dao
interface ConceptDAO {
    @Query("SELECT * FROM concept")
    fun getAll() : List<Concept>
}