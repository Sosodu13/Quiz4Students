package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quizapp.model.data.Question

@Dao
interface QuestionDAO {
    @Query("SELECT * FROM question")
    fun getAll() : List<Question>

    @Query("Select count(*) from question")
    fun countQuestion(): Int

    @Insert
    fun insertAll(vararg questions: Question)
}