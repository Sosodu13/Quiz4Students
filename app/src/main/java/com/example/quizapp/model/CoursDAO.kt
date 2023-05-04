package com.example.quizapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.quizapp.model.data.Concept
import com.example.quizapp.model.data.Cours

@Dao
interface CoursDAO {
    @Query("SELECT * FROM cours")
    fun getAll() : List<Cours>

    @Insert
    fun insertAll(vararg cours: Cours)

    @Query("SELECT * FROM cours LIMIT 1 OFFSET :position")
    fun getByPosition(position: Int): Cours?

    @Query("SELECT COUNT(*) FROM question q WHERE q.concept_id =:param AND  q.watched = 1")
    fun getCountWatchedQuestion(param:Long?) : Int

    @Query("SELECT COUNT(*) FROM question q WHERE q.concept_id =:param")
    fun getCountQuestionByConceptd(param:Long?) : Int

    @Query("SELECT COUNT(*) FROM question q  WHERE q.concept_id =:param AND q.validated = 1")
    fun getCountQuestionValidated(param:Long?) : Int

    @Update
    fun update(cours: Cours)
}