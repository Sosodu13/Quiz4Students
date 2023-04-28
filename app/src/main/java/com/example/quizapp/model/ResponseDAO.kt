package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.Response

@Dao
interface ResponseDAO {
    @Query("SELECT * FROM response")
    fun getAll() : List<Response>

    @Insert
    fun insertAll(vararg responses: Response)

}