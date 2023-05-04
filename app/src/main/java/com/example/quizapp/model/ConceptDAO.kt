package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.Cours
import com.example.quizapp.model.data.Question

@Dao
interface ConceptDAO {
    @Query("SELECT * FROM concept")
    fun getAll() : List<Concept>

    @Insert
    fun insertAll(vararg concepts: Concept)

    @Query("SELECT * FROM concept LIMIT 1 OFFSET :position")
    fun getByPosition(position: Int): Concept?
}