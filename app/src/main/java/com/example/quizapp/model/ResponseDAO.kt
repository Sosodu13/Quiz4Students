package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Query
import com.example.quizapp.model.data.Response

@Dao
interface ResponseDAO {
    @Query("SELECT * FROM response")
    fun getAll() : List<Response>
}